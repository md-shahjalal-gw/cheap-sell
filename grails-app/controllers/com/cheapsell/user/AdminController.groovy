package com.cheapsell.user

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AdminController {

    AdminService adminService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond adminService.list(params), model:[adminCount: adminService.count()]
    }

    def show(Long id) {
        respond adminService.get(id)
    }

    def create() {
        respond new Admin(params)
    }

    def save(Admin admin) {
        if (admin == null) {
            notFound()
            return
        }

        try {
            adminService.save(admin)
        } catch (ValidationException e) {
            respond admin.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'admin.label', default: 'Admin'), admin.id])
                redirect admin
            }
            '*' { respond admin, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond adminService.get(id)
    }

    def update(Admin admin) {
        if (admin == null) {
            notFound()
            return
        }

        try {
            adminService.save(admin)
        } catch (ValidationException e) {
            respond admin.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'admin.label', default: 'Admin'), admin.id])
                redirect admin
            }
            '*'{ respond admin, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        adminService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'admin.label', default: 'Admin'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'admin.label', default: 'Admin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
