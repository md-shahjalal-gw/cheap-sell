package com.cheapsell


import grails.plugin.springsecurity.SpringSecurityUtils
import groovy.transform.CompileStatic

@CompileStatic
class AuthUtils {

    static boolean hasRole(String role) {
        return SpringSecurityUtils.ifAllGranted(role)
    }

}
