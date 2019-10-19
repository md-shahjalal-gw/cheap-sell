package com.cheapsell.transaction

import grails.gorm.services.Service

@Service(UserItem)
interface UserItemService {

    UserItem get(Serializable id)

    List<UserItem> list(Map args)

    Long count()

    void delete(Serializable id)

    UserItem save(UserItem userItem)

}