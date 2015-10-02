package uk.org.pmms.docserver



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DataObjectsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DataObjects.list(params), model:[dataObjectsInstanceCount: DataObjects.count()]
    }

    def show(DataObjects dataObjectsInstance) {
        respond dataObjectsInstance
    }

    def create() {
        respond new DataObjects(params)
    }

    @Transactional
    def save(DataObjects dataObjectsInstance) {
        if (dataObjectsInstance == null) {
            notFound()
            return
        }

        if (dataObjectsInstance.hasErrors()) {
            respond dataObjectsInstance.errors, view:'create'
            return
        }

        dataObjectsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dataObjects.label', default: 'DataObjects'), dataObjectsInstance.id])
                redirect dataObjectsInstance
            }
            '*' { respond dataObjectsInstance, [status: CREATED] }
        }
    }

    def edit(DataObjects dataObjectsInstance) {
        respond dataObjectsInstance
    }

    @Transactional
    def update(DataObjects dataObjectsInstance) {
        if (dataObjectsInstance == null) {
            notFound()
            return
        }

        if (dataObjectsInstance.hasErrors()) {
            respond dataObjectsInstance.errors, view:'edit'
            return
        }

        dataObjectsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DataObjects.label', default: 'DataObjects'), dataObjectsInstance.id])
                redirect dataObjectsInstance
            }
            '*'{ respond dataObjectsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DataObjects dataObjectsInstance) {

        if (dataObjectsInstance == null) {
            notFound()
            return
        }

        dataObjectsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DataObjects.label', default: 'DataObjects'), dataObjectsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dataObjects.label', default: 'DataObjects'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
