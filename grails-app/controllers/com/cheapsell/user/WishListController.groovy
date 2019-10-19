package com.cheapsell.user

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WishListController {

    WishListService wishListService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond wishListService.list(params), model:[wishListCount: wishListService.count()]
    }

    def show(Long id) {
        respond wishListService.get(id)
    }

    def create() {
        respond new WishList(params)
    }

    def save(WishList wishList) {
        if (wishList == null) {
            notFound()
            return
        }

        try {
            wishListService.save(wishList)
        } catch (ValidationException e) {
            respond wishList.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'wishList.label', default: 'WishList'), wishList.id])
                redirect wishList
            }
            '*' { respond wishList, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond wishListService.get(id)
    }

    def update(WishList wishList) {
        if (wishList == null) {
            notFound()
            return
        }

        try {
            wishListService.save(wishList)
        } catch (ValidationException e) {
            respond wishList.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'wishList.label', default: 'WishList'), wishList.id])
                redirect wishList
            }
            '*'{ respond wishList, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        wishListService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'wishList.label', default: 'WishList'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'wishList.label', default: 'WishList'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
