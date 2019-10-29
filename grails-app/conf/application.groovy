grails {
    gorm {
        autowire: true
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
//            filterChain {
//                chainMap = [
//                        [pattern: '/item/**',filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],// <2>
//                        [pattern: '/**', filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
//                ]
//            }
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

//            rejectIfNoRule = false
//            fii {
//                rejectPublicInvocations = false
//            }

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
                    [pattern: '/login/**',              access: ['permitAll']],
                    [pattern: '/logout',                access: ['permitAll']],
                    [pattern: '/logout/**',             access: ['permitAll']],
                    [pattern: '/dbconsole/**',          access: ['permitAll']],
                    [pattern: '/home/**',       access: ['ROLE_SELLER', 'ROLE_BUYER', 'ROLE_ADMIN']],
                    [pattern: '/user/**',       access: ['ROLE_SELLER', 'ROLE_BUYER', 'ROLE_ADMIN']],
                    [pattern: '/item',          access: ['ROLE_SELLER', 'ROLE_BUYER', 'ROLE_ADMIN']],
                    [pattern: '/item/index',    access: ['ROLE_SELLER', 'ROLE_BUYER', 'ROLE_ADMIN']],
                    [pattern: '/item/create',   access: ['ROLE_SELLER']],
                    [pattern: '/item/save',     access: ['ROLE_SELLER']],
                    [pattern: '/item/update',   access: ['ROLE_SELLER']],
                    [pattern: '/item/delete/*', access: ['ROLE_SELLER']],
                    [pattern: '/item/edit/*',   access: ['ROLE_SELLER']],
                    [pattern: '/item/show/*',   access: ['ROLE_SELLER', 'ROLE_BUYER', 'ROLE_ADMIN']]
            ]
        }
    }
}