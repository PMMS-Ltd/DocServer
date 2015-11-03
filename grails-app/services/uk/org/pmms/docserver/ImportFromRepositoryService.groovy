package uk.org.pmms.docserver

import grails.transaction.Transactional
@Transactional
class ImportFromRepositoryService {
	
	def CMISService
	def grailsApplication
	
    def importTemplates() {
		def templateFiles = CMISService.getQueryResults("select cmis:objectId, cmis:description, cmis:name from cmis:document where in_folder('" + grailsApplication.config.grails.alfresco.repo.templatefolder +"')")
		println templateFiles
		println templateFiles.size()
		def templateSize = templateFiles.size()
		if(templateSize == 0){
			return "No Files to Import"
		}
		else{
			templateFiles.each(){
				println "Processing file: " + it['objectId']
				
				if (!Templates.findByFilePath(it['objectId'])){
					def description = it['description'] ?: it['name']
					def newTemplate = new Templates(description: description, filePath: it['objectId'], name: it['name']).save(failOnError: true)
					println "Succesfully imported: " + newTemplate
				}
			}
			return "Imported Templates Successfully"
		}
    }
}
