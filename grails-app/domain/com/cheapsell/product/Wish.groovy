package com.cheapsell.product

import com.cheapsell.user.Login

class Wish {

    String name
    String description
    int price
    Login login

    static belongsTo = [login: Login]

    static constraints = {
        description(nullable: true)
        price(nullable: true)
    }
}
