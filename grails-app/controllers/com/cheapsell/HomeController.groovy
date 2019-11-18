package com.cheapsell

import com.cheapsell.user.Login
import com.cheapsell.user.Role
import com.cheapsell.user.User
import com.cheapsell.user.UserService
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.SpringSecurityUtils
import org.springframework.beans.factory.annotation.Autowired

class HomeController {

    @Autowired
    SpringSecurityService springSecurityService

    def index() {
        def role = ''
        def userProfile = ''

        if (AuthUtils.hasRole(Role.ADMIN)) {
            role = 'admin'
        } else if (AuthUtils.hasRole(Role.USER)) {
            role = 'user'
        }

        Login login = (Login) springSecurityService.getCurrentUser()
        User user = User.findByLogin(login)

        if (user != null) {
            userProfile = user.getUserProfileType().name()
        }

        render(view:"/index", model: [role: role, user: login.username, userId: user?.id, userProfile: userProfile]);
    }
}
