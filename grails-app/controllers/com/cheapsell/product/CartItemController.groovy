package com.cheapsell.product

import com.cheapsell.user.CreditInformation
import com.cheapsell.user.Login
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.beans.factory.annotation.Autowired

class CartItemController {

    @Autowired
    SpringSecurityService springSecurityService

    @Autowired
    CartService cartService;

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

    def checkout() {
        if (CreditInformation.findByLogin((Login) springSecurityService.getCurrentUser()) == null) {
            flash.message = "You have no credit information. Add one first"

            redirect(uri: '/creditInformation/create')
        }

        cartService.purchaseAll()

        flash.message = "Transaction Successful"

        redirect(uri: '/item/index')
    }

}
