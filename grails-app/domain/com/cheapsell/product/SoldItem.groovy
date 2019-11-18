package com.cheapsell.product

import com.cheapsell.user.Login

class SoldItem {

    private static final long serialVersionUID = 1

    Item item
    Date purchaseDate
    Login buyer

    static belongsTo = [buyer: Login, item: Item]

    static constraints = {
        item unique: true
    }
}
