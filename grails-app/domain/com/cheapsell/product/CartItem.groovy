package com.cheapsell.product

import com.cheapsell.user.Login
import grails.compiler.GrailsCompileStatic
import org.codehaus.groovy.util.HashCodeHelper

@GrailsCompileStatic
class CartItem implements Serializable {

    private static final long serialVersionUID = 1

    Item item
    Cart cart
    int price
    String name
    Date dateAdded

    static belongsTo = [login:Login, item:Item, cart: Cart]

    static constraints = {
    }

    @Override
    boolean equals(other) {
        if (other instanceof CartItem) {
            other.itemId == item?.id
        }
    }

    @Override
    int hashCode() {
        int hashCode = HashCodeHelper.initHash()
        if (item) {
            hashCode = HashCodeHelper.updateHash(hashCode, item.id)
        }
        hashCode
    }
}
