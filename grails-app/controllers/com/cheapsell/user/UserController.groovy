package com.cheapsell.user

import com.cheapsell.AuthUtils
import grails.plugin.springsecurity.SpringSecurityService
import grails.validation.ValidationException
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*

class UserController {

    @Autowired
    SpringSecurityService springSecurityService

    UserService userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        if (!AuthUtils.hasRole(Role.ADMIN)) {
            redirect(uri: '/login/denied')
        }

        params.max = Math.min(max ?: 10, 100)
        respond userService.list(params), model:[userCount: userService.count()]
    }

    def show(Long id) {
        respond userService.get(id)
    }

    def create() {
        if (!AuthUtils.hasRole(Role.ADMIN)) {
            redirect(uri: '/login/denied')
        }

        respond new User(params)
    }

    def save(User user) {
        if (user == null) {
            notFound()
            return
        }

        try {
            user.setCreateDate(new Date())
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*' { respond user, [status: CREATED] }
        }
    }

    def edit(Long id) {
        if (!AuthUtils.hasRole(Role.ADMIN) && springSecurityService.getCurrentUserId() != id) {
            redirect(uri: '/login/denied')
        }

        respond userService.get(id)
    }

    def update(User user) {
        if (user == null) {
            notFound()
            return
        }

        if (!AuthUtils.hasRole(Role.ADMIN) && springSecurityService.getCurrentUserId() != user.id) {
            redirect(uri: '/login/denied')
        }

        try {
            user.setUpdateDate(new Date())
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), user.id])
                redirect user
            }
            '*'{ respond user, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        if (!AuthUtils.hasRole(Role.ADMIN)) {
            redirect(uri: '/login/denied')
        }

        userService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
