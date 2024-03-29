package com.cheapsell.product

import com.cheapsell.user.Login
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class CartService {

    @Autowired
    SpringSecurityService springSecurityService

    @Autowired
    ItemService itemService

    def getCardByLogin() {
        Login login = (Login) springSecurityService.getCurrentUser()

        Cart cart = Cart.findByLogin(login)

        if (cart == null) {
            cart = new Cart(login: login)
        }

        return cart
    }

    def addToCart(Item item) {
        Cart cart = getCardByLogin()
        cart.setItems(cart.getItems() + 1)
        cart.setTotalPrice(cart.getTotalPrice() + item.price)

        update(cart)

        CartItem cartItem = new CartItem(item: item, cart: cart, price: item.price, dateAdded: new Date(), name: item.name)

        update(cartItem)
    }

    def removeFromCart(Item item) {
        Cart cart = getCardByLogin()
        cart.setItems(cart.getItems() - 1)
        cart.setTotalPrice(cart.getTotalPrice() - item.price)

        CartItem cartItem = CartItem.findByItemAndCartAndLogin(item, cart, cart.getLogin())

        delete(cartItem)

        update(cart)
    }

    def update(Cart cart) {
        cart.setLogin((Login) springSecurityService.getCurrentUser())
        cart.save(flush: true)
    }

    def update(CartItem cartItem) {
        cartItem.setLogin((Login) springSecurityService.getCurrentUser())
        cartItem.save(flush: true)
    }

    def delete(CartItem cartItem) {
        cartItem.delete(flush: true)
    }

    def purchaseAll() {
        Login login = (Login) springSecurityService.getCurrentUser()

        def cartItems = CartItem.findAllByLogin(login)
        for (CartItem cartItem : (cartItems)) {
            def item = cartItem.item

            purchase(item)

            removeFromCart(item)
        }
    }

    def purchase(Item item) {
        Login login = (Login) springSecurityService.getCurrentUser()

        item.setSold(true)
        itemService.save(item)

        def soldItem = new SoldItem(item: item, buyer: login, purchaseDate: new Date())
        soldItem.save(flush: true)
    }
}
