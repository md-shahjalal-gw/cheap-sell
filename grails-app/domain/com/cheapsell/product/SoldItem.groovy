package com.cheapsell.product

import com.cheapsell.user.Login
import grails.compiler.GrailsCompileStatic
import org.codehaus.groovy.util.HashCodeHelper

@GrailsCompileStatic
class SoldItem implements Serializable {

    private static final long serialVersionUID = 1

    Item item
    int price
    Date purchaseDate

    static belongsTo = [login:Login, item:Item]

    static constraints = {
    }

    @Override
    boolean equals(other) {
        if (other instanceof SoldItem) {
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
