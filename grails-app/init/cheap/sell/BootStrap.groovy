package cheap.sell

import com.cheapsell.user.ContactType
import com.cheapsell.user.LoginRole
import com.cheapsell.user.Role
import com.cheapsell.user.Login
import com.cheapsell.user.User
import com.cheapsell.user.UserProfileType
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class BootStrap {

    def init = { servletContext ->
        def authorities = ['ROLE_ADMIN', 'ROLE_BUYER', 'ROLE_SELLER']
        authorities.each { String authority ->
            if (!Role.findByAuthority(authority)) {
                new Role(authority: authority).save()
            }
        }

        if (!Login.findByUsername('jyoung')) {
            def l = new Login(username: 'jyoung', password: 'gwu123')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority('ROLE_ADMIN')).save(flush: true)

            def u = new User(firstName: 'Jincheg', lastName: 'Young', contactStreet1: '654652 JHHKJ',
                    contactStreet2: 'Apt 1', contactCity: 'DC', contactZip: '20037', contactState: 'DC', rating: 0,
                    userProfileType: UserProfileType.SELLER, contactEmail: "jkkjk@jkkjk", contactPhone: '215121',
                    contactType: ContactType.PRIMARY
            )
            u.setLogin(l)
            u.save("flush": true)
        }

        if (!Login.findByUsername('akahata')) {
            def l = new Login(username: 'akahata', password: 'gwu123')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority('ROLE_BUYER')).save(flush: true)

            def u = new User(firstName: 'Akinori', lastName: 'Kahata', contactStreet1: '654652 JHHKJ',
                    contactStreet2: 'Apt 1', contactCity: 'DC', contactZip: '20037', contactState: 'DC', rating: 0,
                    userProfileType: UserProfileType.SELLER, contactEmail: "jkkjk@jkkjk", contactPhone: '215121',
                    contactType: ContactType.PRIMARY
            )
            u.setLogin(l)
            u.save("flush": true)
        }

        if (!Login.findByUsername('jay')) {
            def l = new Login(username: 'jay', password: 'gwu123')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority('ROLE_SELLER')).save(flush: true)

            def u = new User(firstName: 'S', lastName: 'Jay', contactStreet1: '654652 JHHKJ',
                    contactStreet2: 'Apt 1', contactCity: 'DC', contactZip: '20037', contactState: 'DC', rating: 0,
                    userProfileType: UserProfileType.SELLER, contactEmail: "jkkjk@jkkjk", contactPhone: '215121',
                    contactType: ContactType.PRIMARY
            )
            u.setLogin(l)
            u.save("flush": true)
        }

        assert Role.count() == 3
        assert Login.count() == 3
        assert LoginRole.count() == 3
        assert User.count == 3
    }
    def destroy = {
    }
}
