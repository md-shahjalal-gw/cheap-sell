package com.cheapsell.product

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class ItemEmailService {

    @Autowired
    SpringSecurityService springSecurityService

    def mailService

    def sendAvailableNotification(String name, int price, Long id) {
        def wishList = Wish.findByName(name)

        for (Wish wish : wishList) {
            if ((Math.abs(wish.price - price) / wish.price) < 0.11) {
                mailService.sendMail {
                    from "info.cheapsell@gmail.com"
                    to wish.getLogin().getEmail()
                    subject "Item from Wish list available in Cheapsell"
                    text "Your item from wish list available. " +  name +
                            "\nYou can see now http://localhost:8080/item/show/" + id
                }
            }
        }
    }
}