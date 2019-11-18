package com.cheapsell.product


import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.beans.factory.annotation.Autowired

class CartController {

    @Autowired
    SpringSecurityService springSecurityService

    @Autowired
    CartService cartService

    def addToCart = {
        Item item = Item.get(params.id)

        cartService.addToCart(item)

        redirect(Item.get(item.id))
    }

    def removeFromCart = {
        Item item = Item.get(params.id)

        cartService.removeFromCart(item)

        redirect(Item.get(item.id))
    }
}
