package com.cheapsell.product

class Wish {

    String name
    String description
    int price

    static constraints = {
        description(nullable: true)
        price(nullable: true)
    }
}
