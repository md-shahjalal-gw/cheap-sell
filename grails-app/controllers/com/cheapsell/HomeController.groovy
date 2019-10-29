package com.cheapsell

import com.cheapsell.user.Login
import com.cheapsell.user.Role
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.beans.factory.annotation.Autowired

class HomeController {

    @Autowired
    SpringSecurityService springSecurityService

    def index() {
        def role = ''

        if (AuthUtils.hasRole(Role.ADMIN)) {
            role = 'admin'
        } else if (AuthUtils.hasRole(Role.BUYER)) {
            role = 'buyer'
        } else if (AuthUtils.hasRole(Role.SELLER)) {
            role = 'seller'
        }

        render(view:"/index", model: [role: role, user: ((Login)(springSecurityService.getCurrentUser())).username,
                                      id: springSecurityService.getCurrentUserId()]);
    }
}
