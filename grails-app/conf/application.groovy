grails {
    controllers {
        upload {
            maxFileSize: 26214400
            maxRequestSize: 26214400
        }
    }
    gorm {
        autowire: true
    }
    mail {
        host = "smtp.gmail.com"
        port = 465
        username = "info.cheapsell@gmail.com"
        password = "gwucsci6221"
        props = ["mail.smtp.auth":"true",
                 "mail.smtp.socketFactory.port":"465",
                 "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
                 "mail.smtp.socketFactory.fallback":"false"]
    }
    plugin {
        springsecurity {
            rest {
                token {
                    storage {
                        useGorm = true
                        tokenDomainClassName = 'com.cheapsell.security.AuthenticationToken'
                    }
                }
            }
            successHandler {
                alwaysUseDefault = true
                defaultTargetUrl = '/home/index'
            }
            logout {
                afterLogoutUrl = '/login'
            }
            securityConfigType = "InterceptUrlMap"
            userLookup {
                userDomainClassName = 'com.cheapsell.user.Login'
                authorityJoinClassName = 'com.cheapsell.user.LoginRole'
            }
            authority {
                className = 'com.cheapsell.user.Role'
            }
            logout {
                postOnly = false
            }
            ui {
                register{
//                    postRegisterUrl = '/login/auth'
                    emailFrom = 'info.cheapsell@gmail.com'
                    emailSubject = 'Thank you for register with Cheap Sell'
                    defaultRoleNames = ['ROLE_USER']
                    requireEmailValidation = true
                }
            }

            interceptUrlMap = [
                    [pattern: '/',                      access: ['permitAll']],
                    [pattern: '/error',                 access: ['permitAll']],
                    [pattern: '/index',                 access: ['permitAll']],
                    [pattern: '/index.gsp',             access: ['permitAll']],
                    [pattern: '/shutdown',              access: ['permitAll']],
                    [pattern: '/assets/**',             access: ['permitAll']],
                    [pattern: '/**/js/**',              access: ['permitAll']],
                    [pattern: '/**/css/**',             access: ['permitAll']],
                    [pattern: '/**/images/**',          access: ['permitAll']],
                    [pattern: '/**/favicon.ico',        access: ['permitAll']],
                    [pattern: '/register/**',           access: ['permitAll']],
                    [pattern: '/login/**',              access: ['permitAll']],
                    [pattern: '/logout',                access: ['permitAll']],
                    [pattern: '/logout/**',             access: ['permitAll']],
                    [pattern: '/dbconsole/**',          access: ['permitAll']],
                    [pattern: '/home/**',               access: ['ROLE_USER', 'ROLE_ADMIN']],
                    [pattern: '/user/**',               access: ['ROLE_USER', 'ROLE_ADMIN']],
                    [pattern: '/item/**',               access: ['ROLE_USER', 'ROLE_ADMIN']],
                    [pattern: '/cartItem/**',               access: ['ROLE_USER', 'ROLE_ADMIN']],
                    [pattern: '/cart/**',               access: ['ROLE_USER', 'ROLE_ADMIN']]
            ]
        }
    }
}