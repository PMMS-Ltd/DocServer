package uk.org.pmms.docserver

import static org.springframework.http.HttpStatus.*
import grails.converters.*
import grails.rest.*
import org.codehaus.groovy.grails.web.json.JSONArray
class BatchController extends RestfulController{

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	BatchController() {
		super(Batch)
	}
	def executorService
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Batch.list(params), [status: OK]
    }

    def save(Batch batchInstance) {
		//System.out.println(batchInstance as JSON)
		batchInstance.documents.each(){
			
			def template = Templates.get(batchInstance.templateId.toLong())
			it.template = template
			it.save(failOnError: true)
		
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
        respond batchInstance, [status: CREATED]
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
	def processBatch(Batch batchInstance){
		if (!batchInstance){
			render status: NO_CONTENT
		}
		
	}
}
