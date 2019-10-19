package com.cheapsell.user

import com.cheapsell.product.Item

class WishList {

    User user

    static belongsTo = [user:User]
    static hasMany = ["item": Item]

    static constraints = {
    }
}
