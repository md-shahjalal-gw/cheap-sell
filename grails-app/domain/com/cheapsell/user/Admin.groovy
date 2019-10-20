package com.cheapsell.user

class Admin extends Profile {

    static mapping = {
        login lazy: false
    }

    static constraints = {
    }
}
