package com.cheapsell.user

class Profile {

    Login login
    String firstName
    String lastName
    Contact primary
    Contact secondary

    UserProfileType userProfileType

    static mapping = {
        login lazy: false
    }

    static constraints = {
    }
}
