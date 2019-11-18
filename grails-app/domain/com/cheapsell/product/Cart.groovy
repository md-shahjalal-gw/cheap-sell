package com.cheapsell.product

import com.cheapsell.user.Login

class Cart {

    int items
    int price

    static hasMany = [items:Item]
    static belongsTo = [login: Login]

    static constraints = {

    }
}
