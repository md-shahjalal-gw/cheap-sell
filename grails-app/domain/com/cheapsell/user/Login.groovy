package com.cheapsell.user

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes='loginName')
class Login implements Serializable {

    private static final long serialVersionUID = 1

    long id
    long version

    String firstName
    String lastName
    String loginName
    String password

    boolean active
    Date createDate
    Date updateDate

    Contact primaryContact;
    Contact secondaryContact;

    transient springSecurityService

//    protected void encodePassword() {
//        password = springSecurityService.encodePassword(password)
//    }
//
//    static transients = ['springSecurityService']

    static constraints = {
        loginName blank: false, unique: true
        password blank: false, password: true
    }
}
