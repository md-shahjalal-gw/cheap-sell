package com.cheapsell.user

import grails.gorm.services.Service

@Service(UserProfileType)
interface UserProfileTypeService {

    UserProfileType get(Serializable id)

    List<UserProfileType> list(Map args)

    Long count()

    void delete(Serializable id)

    UserProfileType save(UserProfileType userProfileType)

}