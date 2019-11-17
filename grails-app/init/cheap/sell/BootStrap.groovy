package cheap.sell

import com.cheapsell.user.*
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class BootStrap {

    def init = { servletContext ->
        def authorities = [Role.ADMIN, Role.SELLER, Role.BUYER]
        authorities.each { String authority ->
            if (!Role.findByAuthority(authority)) {
                new Role(authority: authority).save()
            }
        }

        if (!Login.findByUsername('jyoung')) {
            def l = new Login(username: 'jyoung', password: 'gwu123')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority(Role.ADMIN)).save(flush: true)

            def u = new User(firstName: 'Jincheg', lastName: 'Young', contactStreet1: '654652 JHHKJ',
                    contactStreet2: 'Apt 1', contactCity: 'DC', contactZip: '20037', contactState: 'DC', rating: 0,
                    userProfileType: UserProfileType.ADMIN, contactEmail: "jkkjk@jkkjk.com", contactPhone: '215121',
                    createDate: new Date(), updateDate: new Date()

            )
            u.setLogin(l)
            u.save("flush": true)
        }

        if (!Login.findByUsername('akahata')) {
            def l = new Login(username: 'akahata', password: 'gwu123')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority(Role.BUYER)).save(flush: true)

            def u = new User(firstName: 'Akinori', lastName: 'Kahata', contactStreet1: '654652 JHHKJ',
                    contactStreet2: 'Apt 1', contactCity: 'DC', contactZip: '20037', contactState: 'DC', rating: 0,
                    userProfileType: UserProfileType.BUYER, contactEmail: "jkkjk@jkkjk.com", contactPhone: '215121',
                    createDate: new Date(), updateDate: new Date()
            )
            u.setLogin(l)
            u.save("flush": true)
        }

        if (!Login.findByUsername('jay')) {
            def l = new Login(username: 'jay', password: 'gwu123')
            l.save()
            new LoginRole(login: l, role: Role.findByAuthority(Role.SELLER)).save(flush: true)

            def u = new User(firstName: 'S', lastName: 'Jay', contactStreet1: '654652 JHHKJ',
                    contactStreet2: 'Apt 1', contactCity: 'DC', contactZip: '20037', contactState: 'DC', rating: 0,
                    userProfileType: UserProfileType.SELLER, contactEmail: "jkkjk@jkkjk.com     " +
                    "", contactPhone: '215121',
                    createDate: new Date(), updateDate: new Date()
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
