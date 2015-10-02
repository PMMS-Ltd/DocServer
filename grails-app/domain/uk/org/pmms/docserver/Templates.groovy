package uk.org.pmms.docserver

import java.util.SortedSet;

class Templates {
	String name
	String description
	String filePath
	
	static hasMany = [dataObjects: DataObjects]
	
    static constraints = {
		filePath nullable: true
    }
	
	String toString() {
		return name
	}
	
}
