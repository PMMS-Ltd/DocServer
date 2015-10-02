package uk.org.pmms.docserver

import grails.transaction.Transactional;
import grails.converters.JSON

class UtilsController {

    def index() { }
	
	@Transactional
    def save() {
		//System.out.println request.JSON
		//System.out.println request.XML
		//render request.JSON
		def batchInstance = null
		if(request.JSON != ''){
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
            
			render batchInstance.getErrors() as JSON
            return
        }

        batchInstance.save(flush: true, failOnError: true)
        respond batchInstance
    }
}
