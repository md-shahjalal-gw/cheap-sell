package com.cheapsell.user

import grails.plugin.springsecurity.SpringSecurityService
import grails.validation.ValidationException
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*

class CreditInformationController {

    @Autowired
    SpringSecurityService springSecurityService

    CreditInformationService creditInformationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def c = CreditInformation.createCriteria()
        def results = c.list(max: Math.min(max ?: 10, 100)) {
            eq("login", springSecurityService.currentUser)
        }

        respond results, model:[creditInformationCount: creditInformationService.count()]
    }

    def show(Long id) {
        respond creditInformationService.get(id)
    }

    def create() {
        respond new CreditInformation(params)
    }

    def save(CreditInformation creditInformation) {
        if (creditInformation == null) {
            notFound()
            return
        }

        try {
            creditInformation.setLogin(springSecurityService.getCurrentUser())
            creditInformationService.save(creditInformation)
        } catch (ValidationException e) {
            respond creditInformation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'creditInformation.label', default: 'CreditInformation'), creditInformation.id])
                redirect creditInformation
            }
            '*' { respond creditInformation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond creditInformationService.get(id)
    }

    def update(CreditInformation creditInformation) {
        if (creditInformation == null) {
            notFound()
            return
        }

        try {
            creditInformationService.save(creditInformation)
        } catch (ValidationException e) {
            respond creditInformation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'creditInformation.label', default: 'CreditInformation'), creditInformation.id])
                redirect creditInformation
            }
            '*'{ respond creditInformation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        creditInformationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'creditInformation.label', default: 'CreditInformation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'creditInformation.label', default: 'CreditInformation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
