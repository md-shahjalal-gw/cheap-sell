package com.cheapsell.product

import com.cheapsell.user.User
import grails.compiler.GrailsCompileStatic
import org.codehaus.groovy.util.HashCodeHelper

@GrailsCompileStatic
class SellerItem implements Serializable {

    private static final long serialVersionUID = 1

    User user
    Item item
    int price
    Date displayDate

    static constraints = {
    }

    static mapping = {
        id composite: ['user', 'item']
        version false
    }

    @Override
    boolean equals(other) {
        boolean isEquals = false

        if (other instanceof SellerItem) {
            isEquals = other.userId == user?.id && other.itemId == item?.id
        }

        isEquals
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
}
