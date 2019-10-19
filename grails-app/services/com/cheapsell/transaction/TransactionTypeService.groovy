package com.cheapsell.transaction

import grails.gorm.services.Service

@Service(TransactionType)
interface TransactionTypeService {

    TransactionType get(Serializable id)

    List<TransactionType> list(Map args)

    Long count()

    void delete(Serializable id)

    TransactionType save(TransactionType transactionType)

}