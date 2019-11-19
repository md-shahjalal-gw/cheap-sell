package com.cheapsell.product

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WishController {

    WishService wishService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond wishService.list(params), model:[wishCount: wishService.count()]
    }

    def show(Long id) {
        respond wishService.get(id)
    }

    def create() {
        respond new Wish(params)
    }

    def save(Wish wish) {
        if (wish == null) {
            notFound()
            return
        }

        try {
            wishService.save(wish)
        } catch (ValidationException e) {
            respond wish.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'wish.label', default: 'Wish'), wish.id])
                redirect wish
            }
            '*' { respond wish, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond wishService.get(id)
    }

    def update(Wish wish) {
        if (wish == null) {
            notFound()
            return
        }

        try {
            wishService.save(wish)
        } catch (ValidationException e) {
            respond wish.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'wish.label', default: 'Wish'), wish.id])
                redirect wish
            }
            '*'{ respond wish, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        wishService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'wish.label', default: 'Wish'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'wish.label', default: 'Wish'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
