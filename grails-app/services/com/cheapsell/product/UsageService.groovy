package com.cheapsell.product

import grails.gorm.services.Service

@Service(Usage)
interface UsageService {

    Usage get(Serializable id)

    List<Usage> list(Map args)

    Long count()

    void delete(Serializable id)

    Usage save(Usage usage)

}