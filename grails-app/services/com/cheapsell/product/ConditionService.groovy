package com.cheapsell.product

import grails.gorm.services.Service

@Service(Condition)
interface ConditionService {

    Condition get(Serializable id)

    List<Condition> list(Map args)

    Long count()

    void delete(Serializable id)

    Condition save(Condition condition)

}