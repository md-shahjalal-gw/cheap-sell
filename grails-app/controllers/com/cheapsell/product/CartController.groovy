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

        flash.message = item.name + " Successfully Added to Cart"

        redirect(Item.get(item.id))
    }

    def removeFromCart = {
        Item item = Item.get(params.id)

        cartService.removeFromCart(item)

        flash.message = item.name + " Successfully Removed from Cart"

        redirect(Item.get(item.id))
    }

    def buyNow = {
        Item item = Item.get(params.id)

        cartService.purchase(item)

        flash.message = "Purchase Successful"

        redirect(uri: '/item/index')
    }
}
