package com.cheapsell.product

import com.cheapsell.user.Login

class Cart {

    private static final long serialVersionUID = 1

    int items
    int totalPrice

    static hasMany = [items:Item]
    static belongsTo = [login: Login]

    static constraints = {

    }
}
