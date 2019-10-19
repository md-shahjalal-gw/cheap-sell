package com.cheapsell.transaction

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserItemController {

    UserItemService userItemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userItemService.list(params), model:[userItemCount: userItemService.count()]
    }

    def show(Long id) {
        respond userItemService.get(id)
    }

    def create() {
        respond new UserItem(params)
    }

    def save(UserItem userItem) {
        if (userItem == null) {
            notFound()
            return
        }

        try {
            userItemService.save(userItem)
        } catch (ValidationException e) {
            respond userItem.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userItem.label', default: 'UserItem'), userItem.id])
                redirect userItem
            }
            '*' { respond userItem, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userItemService.get(id)
    }

    def update(UserItem userItem) {
        if (userItem == null) {
            notFound()
            return
        }

        try {
            userItemService.save(userItem)
        } catch (ValidationException e) {
            respond userItem.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userItem.label', default: 'UserItem'), userItem.id])
                redirect userItem
            }
            '*'{ respond userItem, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userItemService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userItem.label', default: 'UserItem'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userItem.label', default: 'UserItem'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
