package com.cheapsell.user

class Profile extends Login {

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

    UserProfileType userProfileType

    static constraints = {
    }
}
