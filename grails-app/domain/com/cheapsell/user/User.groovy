package com.cheapsell.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class User implements Serializable {

    private static final long serialVersionUID = 1

    String firstName
    String lastName
    Date dateOfBirth
    double rating

    String contactStreet1
    String contactStreet2
    String contactCity
    String contactZip
    String contactState
    String contactPhone

    Date createDate
    Date updateDate

    Login login
    UserProfileType userProfileType

    static hasMany = [creditInformation: CreditInformation]

    static mapping = {
        login lazy: false
    }

    static constraints = {
        contactStreet2(nullable: true)
        rating(nullable: true, range: 0..5)
        updateDate(nullable: true)
        dateOfBirth(nullable: true)
        contactPhone(nullable: true)
    }
}
