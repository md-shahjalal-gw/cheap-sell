package com.cheapsell.product

import com.cheapsell.user.Login
import grails.compiler.GrailsCompileStatic
import org.codehaus.groovy.util.HashCodeHelper

@GrailsCompileStatic
class UserItem implements Serializable {

    private static final long serialVersionUID = 1

    Login seller
    Login buyer
    Item item
    int price
    Date purchaseDate

    static constraints = {
    }

    @Override
    boolean equals(other) {
        if (other instanceof UserItem) {
            other.sellerId == seller?.id && other.itemId == item?.id
        }
    }

    @Override
    int hashCode() {
        int hashCode = HashCodeHelper.initHash()
        if (seller) {
            hashCode = HashCodeHelper.updateHash(hashCode, seller.id)
        }
        if (item) {
            hashCode = HashCodeHelper.updateHash(hashCode, item.id)
        }
        hashCode
    }

    static mapping = {
        id composite: ['seller', 'item']
        version false
    }
}
