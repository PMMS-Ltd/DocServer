package uk.org.pmms.docserver

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder

@Transactional
class MetadataService {
	def grailsApplication
	def rest = new RestBuilder()
	
    def getObject(String objectType, Long objectId){
		def url = grailsApplication.config.pmms.apiUrl + objectType + '/' + objectId + '.json'
		def resp = rest.get(url){
			auth grailsApplication.config.pmms.auth.user,grailsApplication.config.pmms.auth.password
		}
		return resp.json
	}
}
