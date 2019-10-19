package com.cheapsell.user

import com.cheapsell.product.Item
import com.cheapsell.transaction.TransactionHistory

class User {

    Login login
    Profile profile
    double rating
    TransactionHistory transactionHistory
    WishList wishList;

    static hasMany = [items: Item]

    static mapping = {
        login lazy: false
        profile lazy: false
    }

    static constraints = {
    }
}
