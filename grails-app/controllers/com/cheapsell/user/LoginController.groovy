package com.cheapsell.user

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LoginController {

    LoginService loginService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond loginService.list(params), model:[loginCount: loginService.count()]
    }

    def show(Long id) {
        respond loginService.get(id)
    }

    def create() {
        respond new Login(params)
    }

    def save(Login login) {
        if (login == null) {
            notFound()
            return
        }

        try {
            loginService.save(login)
        } catch (ValidationException e) {
            respond login.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'login.label', default: 'Login'), login.id])
                redirect login
            }
            '*' { respond login, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond loginService.get(id)
    }

    def update(Login login) {
        if (login == null) {
            notFound()
            return
        }

        try {
            loginService.save(login)
        } catch (ValidationException e) {
            respond login.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'login.label', default: 'Login'), login.id])
                redirect login
            }
            '*'{ respond login, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        loginService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'login.label', default: 'Login'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'login.label', default: 'Login'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
