package com.cheapsell.user

import grails.gorm.services.Service

@Service(CreditInformation)
interface CreditInformationService {

    CreditInformation get(Serializable id)

    List<CreditInformation> list(Map args)

    Long count()

    void delete(Serializable id)

    CreditInformation save(CreditInformation creditInformation)

}