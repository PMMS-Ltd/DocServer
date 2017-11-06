package uk.org.pmms.docserver
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import static org.junit.Assert.*;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import grails.converters.JSON

class MailMergeController {
	def DocxDocumentMergerAndConverterService
	def CMISService
	def grailsApplication
    def index() { 
		
	}
	def merge() {
		System.out.println request.JSON
		if(request.JSON != null){
			System.out.println request.JSON
			params << request.JSON
		}
		//println params
		String templatePath = params.templatePath
		
			   
			   byte[] mergedOutput = docxDocumentMergerAndConverterService.mergeAndGenerateOutput(templatePath, TemplateEngineKind.Freemarker, params.fields);
			   assertNotNull(mergedOutput);
			 
		 request.withFormat {
            form multipartForm {
                response.setHeader("Content-disposition", "attachment; filename="+System.nanoTime()+".docx");
				response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
			   	response.outputStream << mergedOutput
            }
            '*' {  render mergedOutput.encodeBase64() }
        }
			   
	}
	def mergePDF() {
		if(request.JSON != null){
			params << request.JSON
		}
		String templatePath = params.templatePath
			   
			   byte[] mergedOutput = docxDocumentMergerAndConverterService.mergeAndGeneratePDFOutput(templatePath, TemplateEngineKind.Freemarker, params.fields);
			   assertNotNull(mergedOutput);
		
			   request.withFormat {
				   form multipartForm {
					   response.setHeader("Content-disposition", "attachment; filename="+System.nanoTime()+".pdf");
					   response.setContentType("application/pdf")
					   response.outputStream << mergedOutput
				   }
				   '*' {  render mergedOutput.encodeBase64() }
			   }
		 
	}
	def mergeSave() {
		
		if(request.JSON != null){
			System.out.println request.JSON
			params << request.JSON
		}			   
	   byte[] mergedOutput = docxDocumentMergerAndConverterService.mergeAndGenerateOutput(params.templatePath, TemplateEngineKind.Freemarker, params.fields);
	   assertNotNull(mergedOutput);
	  
	 def documentId = CMISService.saveDocument(params.destinationPath, params.filename, mergedOutput)  
	 //def documentId = '3df75943-3265-4fb6-ad7a-7e9eea509951'
	 def documentPath = CMISService.getDocumentPath(documentId)
	 render "ms-word:ofv|u|" + grailsApplication.config.grails.alfresco.vtiURL + documentPath.substring(documentPath.indexOf('/')+6)
			   
	}
}
