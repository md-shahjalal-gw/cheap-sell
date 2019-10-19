package com.cheapsell.transaction

import grails.gorm.services.Service

@Service(TransactionHistory)
interface TransactionHistoryService {

    TransactionHistory get(Serializable id)

    List<TransactionHistory> list(Map args)

    Long count()

    void delete(Serializable id)

    TransactionHistory save(TransactionHistory transactionHistory)

}