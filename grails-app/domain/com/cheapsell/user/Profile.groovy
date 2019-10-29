package com.cheapsell.user

class Profile {

    String firstName
    String lastName

    String contactStreet1
    String contactStreet2
    String contactCity
    String contactZip
    String contactState
    String contactEmail
    String contactPhone
    ContactType contactType

    Login login

    static mapping = {
        login lazy: false
    }


    static constraints = {
    }
}
