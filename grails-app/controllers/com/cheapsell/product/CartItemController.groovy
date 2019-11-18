package com.cheapsell.product

import com.cheapsell.user.Login
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.beans.factory.annotation.Autowired

class CartItemController {

    @Autowired
    SpringSecurityService springSecurityService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.login = (Login) springSecurityService.currentUser

        respond CartItem.list(params), model:[cartItemCount: CartItem.count()]

//        def c = Cart.createCriteria()
//        def results = c.list (max: Math.min(max ?: 10, 100)) {
//            eq("login", springSecurityService.currentUser)
//        }
//
//        respond results, model:[cartItemCount: results.count()]
    }
}
