package com.cheapsell.user

import grails.gorm.services.Service

@Service(WishList)
interface WishListService {

    WishList get(Serializable id)

    List<WishList> list(Map args)

    Long count()

    void delete(Serializable id)

    WishList save(WishList wishList)

}