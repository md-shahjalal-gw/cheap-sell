package com.cheapsell.product

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemController {

    ItemService itemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond itemService.list(params), model:[itemCount: itemService.count()]
    }

    def show(Long id) {
        respond itemService.get(id)
    }

    def create() {
        respond new Item(params)
    }

    def save(Item item) {
        if (item == null) {
            notFound()
            return
        }

        try {
            itemService.save(item)
        } catch (ValidationException e) {
            respond item.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), item.id])
                redirect item
            }
            '*' { respond item, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond itemService.get(id)
    }

    def update(Item item) {
        if (item == null) {
            notFound()
            return
        }

        try {
            itemService.save(item)
        } catch (ValidationException e) {
            respond item.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'item.label', default: 'Item'), item.id])
                redirect item
            }
            '*'{ respond item, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        itemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'item.label', default: 'Item'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
