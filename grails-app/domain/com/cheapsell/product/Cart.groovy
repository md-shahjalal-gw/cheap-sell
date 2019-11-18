package com.cheapsell.product

import com.cheapsell.user.Login

class Cart {

    int items
    int totalPrice

    static hasMany = [items:Item]
    static belongsTo = [login: Login]

    static constraints = {

    }
}
