package com.cheapsell.product

import com.cheapsell.AuthUtils
import com.cheapsell.user.Login
import com.cheapsell.user.Role
import com.cheapsell.user.User
import com.cheapsell.user.UserProfileType
import grails.plugin.springsecurity.SpringSecurityService
import grails.validation.ValidationException
import org.springframework.beans.factory.annotation.Autowired

import static org.springframework.http.HttpStatus.*

class ItemController {

    @Autowired
    SpringSecurityService springSecurityService

    ItemService itemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def results = null

        def c = Item.createCriteria()
        def userProfileType = User.findByLogin(springSecurityService.getCurrentUser())?.userProfileType

        if (userProfileType == UserProfileType.BUYER) {
            results = c.list (max: Math.min(max ?: 10, 100)) {
                ne("login", springSecurityService.currentUser)
                and {
                    eq("sold", false)
                }
                order("name", "asc")
            }
        } else if (userProfileType == UserProfileType.SELLER) {
            results = c.list (max: Math.min(max ?: 10, 100)) {
                eq("login", springSecurityService.currentUser)
                and {
                    eq("sold", false)
                }
                order("name", "asc")
            }
        } else if (AuthUtils.hasRole(Role.ADMIN)) {
            results = Item.list(max: Math.min(max ?: 10, 100))
        }

        respond results, model:[itemCount: itemService.count()]
    }

    def show(Long id) {
        def item = itemService.get(id)

        def ownItem = item.login.id == springSecurityService.currentUserId
        def isInCart = !ownItem && CartItem.findByItem(item) != null

        render(view:"show", model: [item: item, isInCart: isInCart, ownItem: ownItem]);
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
            item.setSold(false)
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

        respond item
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
