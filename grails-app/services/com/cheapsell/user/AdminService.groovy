package com.cheapsell.user

import grails.gorm.services.Service

@Service(Admin)
interface AdminService {

    Admin get(Serializable id)

    List<Admin> list(Map args)

    Long count()

    void delete(Serializable id)

    Admin save(Admin admin)

}