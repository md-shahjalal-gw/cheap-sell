package com.cheapsell.user

class CreditInformation {

    String cardNumber
    String cardHolder
    String cvc
    int expireMonth
    int expireYear

    String address1
    String address2
    String city
    String state
    String zip
    String phone

    static belongsTo = [login:Login]

    static constraints = {
        expireMonth(range: 1..12)
        expireYear(range: 2019..2029)
        cardNumber(creditCard: true)

        address1(nullable: true)
        address2(nullable: true)
        city(nullable: true)
        state(nullable: true)
        zip(nullable: true)
        phone(nullable: true)
    }
}
