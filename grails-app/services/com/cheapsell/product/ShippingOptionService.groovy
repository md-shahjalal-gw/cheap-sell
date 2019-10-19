package com.cheapsell.product

import grails.gorm.services.Service

@Service(ShippingOption)
interface ShippingOptionService {

    ShippingOption get(Serializable id)

    List<ShippingOption> list(Map args)

    Long count()

    void delete(Serializable id)

    ShippingOption save(ShippingOption shippingOption)

}