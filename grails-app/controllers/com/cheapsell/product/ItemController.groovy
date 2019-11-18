package com.cheapsell.product

import com.cheapsell.user.Login
import grails.plugin.springsecurity.SpringSecurityService
import grails.validation.ValidationException
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*

class ItemController {

    @Autowired
    SpringSecurityService springSecurityService

    ItemService itemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max, Integer option) {
        def results = null

        def c = Item.createCriteria()
        if (option == 1) {
            results = c.list (max: Math.min(max ?: 10, 100)) {
                ne("login", springSecurityService.currentUser)
            }
        } else if (option == 2) {
            results = c.list (max: Math.min(max ?: 10, 100)) {
                eq("login", springSecurityService.currentUser)
            }
        }

        respond results, model:[itemCount: itemService.count()]
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
            item.setLogin((Login) springSecurityService.getCurrentUser())
            item.setCreateDate(new Date())

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
        def item =  itemService.get(id)

        if (item.loginId != springSecurityService.getCurrentUserId()) {
            redirect(uri: '/login/denied')
        }

        return item
    }

    def update(Item item) {
        if (item == null) {
            notFound()
            return
        }

        if (item.loginId != springSecurityService.getCurrentUserId()) {
            redirect(uri: '/login/denied')
        }

        try {
            item.setUpdateDate(new Date())
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
