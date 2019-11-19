package com.cheapsell.user

import com.cheapsell.Utils

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
        cardNumber(creditCard: true)

        address2(nullable: true)
        city(nullable: true)
        state(nullable: true)
        zip(nullable: true)
        phone(nullable: true)

        address1 validator: { val, obj ->
            if (val == null) {
                return ['missing']
            } else if (obj.city != null && obj.state != null && obj.zip != null && obj.cardHolder != null && obj.address2 != null) {
                def validation = Utils.validateAddress(obj.cardHolder, obj.address1, obj.address2, obj.city, obj.state, obj.zip)
                if (validation == null) {
                    return ['invalid']
                } else if (validation != "valid") {
                    return ['multiple', validation]
                }
            }
        }
    }
}
