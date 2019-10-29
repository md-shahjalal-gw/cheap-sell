package com.cheapsell.user

import com.cheapsell.product.Item
import com.cheapsell.transaction.TransactionHistory

class User extends Profile {

    double rating

    UserProfileType userProfileType

    static constraints = {
    }
}
