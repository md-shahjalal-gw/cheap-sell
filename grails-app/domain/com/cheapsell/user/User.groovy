package com.cheapsell.user

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class User implements Serializable {

    private static final long serialVersionUID = 1

    String firstName
    String lastName
    double rating

    String contactStreet1
    String contactStreet2
    String contactCity
    String contactZip
    String contactState
    String contactEmail
    String contactPhone

    Date createDate
    Date updateDate

    Login login

    static mapping = {
        login lazy: false
    }

    UserProfileType userProfileType

    static constraints = {
        updateDate(nullable: true)
    }
}
