package uk.org.pmms.docserver

import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.rest.*
import org.codehaus.groovy.grails.web.json.JSONArray
class BatchController extends RestfulController{

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	BatchController() {
		super(Batch)
	}
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Batch.list(params), [status: OK]
    }

    def save(Batch batchInstance) {
		System.out.println request.JSON
		/*if(request.JSON != ''){
			System.out.println request.getContentType()
			System.out.println request.JSON
			batchInstance = new Batch()
			batchInstance.batchName = request.JSON.batchName
			if (request.JSON?.documents?.length() > 0){
				request.JSON.documents.each(){
					
					//def doc = new MergeRequest()
					def template = Templates.findById(it.template.toLong())
					def doc = new MergeRequest(template: template)
					doc.properties = it
					doc.addToUrls(it.url)
					doc.save(flush:true, failOnError: true)
					batchInstance.addToDocuments(doc)
					System.out.println doc as JSON
				}
			}
		}
		if (batchInstance == null) {
            render status: NOT_FOUND
            return
        }

        batchInstance.validate()
        if (batchInstance.hasErrors()) {
            
			render batchInstance.getErrors() as JSON , [status: NOT_ACCEPTABLE]
            return
        }

        batchInstance.save(flush: true, failOnError: true)
        respond batchInstance, [status: CREATED]*/
    }

    
    def update(Batch batchInstance) {
        if (batchInstance == null) {
            render status: NOT_FOUND
            return
        }

        batchInstance.validate()
        if (batchInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        batchInstance.save flush:true
        respond batchInstance, [status: OK]
    }

    
    def delete(Batch batchInstance) {

        if (batchInstance == null) {
            render status: NOT_FOUND
            return
        }

        batchInstance.delete flush:true
        render status: NO_CONTENT
    }
}
