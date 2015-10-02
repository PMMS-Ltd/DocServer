package uk.org.pmms.docserver

class MergeRequest {
	Date dateCreated
	Date lastUpdated
	
	String status = 'Not Started'
	Templates template
	String destinationPath
	String filename
	Boolean sendToPrint = false
	
	static hasMany = [urls : String]
	
    static constraints = {
		status inList:['Not Started', 'In Progress', 'Complete', 'Error']
		destinationPath nullable: true
		filename nullable: true
    }
}
