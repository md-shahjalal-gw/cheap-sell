package cheap.sell

import com.cheapsell.user.*
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class BootStrap {

    def init = { servletContext ->
        def authorities = [Role.ADMIN, Role.USER]
        authorities.each { String authority ->
            if (!Role.findByAuthority(authority)) {
                new Role(authority: authority).save()
            }
        }

        if (!Login.findByUsername('jyoung')) {
            def l = new Login(username: 'jyoung', password: 'gwu123', email: 'anc@email.com')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority(Role.ADMIN)).save(flush: true)
        }

        if (!Login.findByUsername('akahata')) {
            def l = new Login(username: 'akahata', password: 'gwu123', email: 'anc@email.com')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority(Role.USER)).save(flush: true)
        }

        if (!Login.findByUsername('jay')) {
            def l = new Login(username: 'jay', password: 'gwu123', email: 'anc@email.com')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority(Role.USER)).save(flush: true)
        }

        assert Role.count() == 2
        assert Login.count() == 3
        assert LoginRole.count() == 3
    }
    def destroy = {
    }
}
