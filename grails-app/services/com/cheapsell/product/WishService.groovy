package com.cheapsell.product

import grails.gorm.services.Service

@Service(Wish)
interface WishService {

    Wish get(Serializable id)

    List<Wish> list(Map args)

    Long count()

    void delete(Serializable id)

    Wish save(Wish wish)

}