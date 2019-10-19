package com.cheapsell.transaction

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TransactionHistoryController {

    TransactionHistoryService transactionHistoryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond transactionHistoryService.list(params), model:[transactionHistoryCount: transactionHistoryService.count()]
    }

    def show(Long id) {
        respond transactionHistoryService.get(id)
    }

    def create() {
        respond new TransactionHistory(params)
    }

    def save(TransactionHistory transactionHistory) {
        if (transactionHistory == null) {
            notFound()
            return
        }

        try {
            transactionHistoryService.save(transactionHistory)
        } catch (ValidationException e) {
            respond transactionHistory.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'transactionHistory.label', default: 'TransactionHistory'), transactionHistory.id])
                redirect transactionHistory
            }
            '*' { respond transactionHistory, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond transactionHistoryService.get(id)
    }

    def update(TransactionHistory transactionHistory) {
        if (transactionHistory == null) {
            notFound()
            return
        }

        try {
            transactionHistoryService.save(transactionHistory)
        } catch (ValidationException e) {
            respond transactionHistory.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'transactionHistory.label', default: 'TransactionHistory'), transactionHistory.id])
                redirect transactionHistory
            }
            '*'{ respond transactionHistory, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        transactionHistoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'transactionHistory.label', default: 'TransactionHistory'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'transactionHistory.label', default: 'TransactionHistory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
