package com.cheapsell.product

import com.cheapsell.user.User
import org.codehaus.groovy.util.HashCodeHelper

@grails.compiler.GrailsCompileStatic
class BuyerItem implements Serializable {

    private static final long serialVersionUID = 1

    User user
    Item item
    int price
    Date purchaseDate

    static constraints = {
    }

    @Override
    boolean equals(other) {
        if (other instanceof SellerItem) {
            other.userId == user?.id && other.itemId == item?.id
        }
    }

    @Override
    int hashCode() {
        int hashCode = HashCodeHelper.initHash()
        if (user) {
            hashCode = HashCodeHelper.updateHash(hashCode, user.id)
        }
        if (item) {
            hashCode = HashCodeHelper.updateHash(hashCode, item.id)
        }
        hashCode
    }

    static mapping = {
        id composite: ['user', 'item']
        version false
    }
}
