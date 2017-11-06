package uk.org.pmms.docserver



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional(readOnly = true)
class TemplatesController {
	def CMISService
	def DocxDocumentMergerAndConverterService
	//def grailsApplication
	def ImportFromRepositoryService
	def MetadataService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
  	
		params.max = Math.min(max ?: 10, 100)		
		respond Templates.list(params), model:[templatesInstanceCount: Templates.count()]
    }

    def show(Templates templatesInstance) {
		
        respond templatesInstance, model:[fields: DocxDocumentMergerAndConverterService.extractFields(templatesInstance)]
    }

    def create() {
        respond new Templates(params)
    }

    @Transactional
    def save(Templates templatesInstance) {
        if (templatesInstance == null) {
            notFound()
            return
        }

        if (templatesInstance.hasErrors()) {
            respond templatesInstance.errors, view:'create'
            return
        }
		if (params.templateFile){
			def CommonsMultipartFile uploadedFile = params.templateFile
			def filePath = CMISService.createDocument(grailsApplication.config.grails.alfresco.repo.templatefolder, uploadedFile, params.description ? params.description : '')
			templatesInstance.filePath = filePath
			
		}
        templatesInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'templates.label', default: 'Templates'), templatesInstance.id])
                redirect templatesInstance
            }
            '*' { respond templatesInstance, [status: CREATED] }
        }
    }

    def edit(Templates templatesInstance) {
        respond templatesInstance
    }

    @Transactional
    def update(Templates templatesInstance) {
        if (templatesInstance == null) {
            notFound()
            return
        }

        if (templatesInstance.hasErrors()) {
            respond templatesInstance.errors, view:'edit'
            return
        }

        templatesInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Templates.label', default: 'Templates'), templatesInstance.id])
                redirect templatesInstance
            }
            '*'{ respond templatesInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Templates templatesInstance) {

        if (templatesInstance == null) {
            notFound()
            return
        }

        templatesInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Templates.label', default: 'Templates'), templatesInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'templates.label', default: 'Templates'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	@Transactional
	def importTemplates(){
		ImportFromRepositoryService.importTemplates();
		redirect action: "index"
	}
	def downloadDocument(){
		def details = CMISService.getQueryResults("select cmis:name, cmis:contentStreamMimeType from cmis:document where cmis:objectId='"+params.documentId+"'")
		def output = CMISService.getDocument(params.documentId)
		if (output) {
			response.setHeader("Content-disposition", "attachment; filename=${details['name'].join(" ")}");
			response.setContentType(details['contentStreamMimeType'].join(" "))
			response.outputStream << output
		}
	}
	def renderMergeForm(){
		def template = Templates.get(params.id);
		if (template != null){
			//render template.filePath
			//respond FormRendererService.renderForm(template)
			render (template:"mergeForm", model: [fields: DocxDocumentMergerAndConverterService.extractFields(template), filePath: template.filePath])
		}
		else{
			render "Template not Found"
		}
	}
	def getMetadata(){
		render MetadataService.getObject(params.obj, params.id.toLong())
	}
	def listTemplates(){
		def c = Templates.createCriteria()
		def results = c.list(params){
			dataObjects{
				eq('name',params.q)
			}
		}
		render results as JSON
	}
}
