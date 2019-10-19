package com.cheapsell.user

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProfileController {

    ProfileService profileService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond profileService.list(params), model:[profileCount: profileService.count()]
    }

    def show(Long id) {
        respond profileService.get(id)
    }

    def create() {
        respond new Profile(params)
    }

    def save(Profile profile) {
        if (profile == null) {
            notFound()
            return
        }

        try {
            profileService.save(profile)
        } catch (ValidationException e) {
            respond profile.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'profile.label', default: 'Profile'), profile.id])
                redirect profile
            }
            '*' { respond profile, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond profileService.get(id)
    }

    def update(Profile profile) {
        if (profile == null) {
            notFound()
            return
        }

        try {
            profileService.save(profile)
        } catch (ValidationException e) {
            respond profile.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'profile.label', default: 'Profile'), profile.id])
                redirect profile
            }
            '*'{ respond profile, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        profileService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'profile.label', default: 'Profile'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'profile.label', default: 'Profile'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
