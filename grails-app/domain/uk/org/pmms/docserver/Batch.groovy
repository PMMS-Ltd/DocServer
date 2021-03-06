package uk.org.pmms.docserver

class Batch {

	String batchName
	String status = 'New'
	
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [documents: MergeRequest]
    static constraints = {
		status inList:['New','Processing','Complete','Error']
    }
}
