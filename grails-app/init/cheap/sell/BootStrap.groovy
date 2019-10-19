package cheap.sell

import com.cheapsell.user.Login

class BootStrap {

    def init = { servletContext ->
        def login = new Login(firstName: 'Jinchen', lastName: 'Young', loginName: 'jyoung', password: 'gwu123').save()
    }
    def destroy = {
    }
}
