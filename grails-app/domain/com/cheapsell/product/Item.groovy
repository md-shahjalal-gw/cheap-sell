package com.cheapsell.product

import com.cheapsell.user.Login
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Item implements Serializable {

    private static final long serialVersionUID = 1

    String name
    int price
    boolean negotiable
    ShippingOption shippingOption
    ItemCondition itemCondition;
    ItemUsage itemUsage
    String description
    int weight
    String color
    String material

    Date createDate
    Date updateDate

    static belongsTo = [login:Login]

    static constraints = {
        name(size: 3..100)
        negotiable()
        color(nullable: true)
        weight(nullable: true)
        material(size: 2..50)
        itemUsage()
        itemCondition()
        description(nullable: true, size: 10..200)
        shippingOption()
        updateDate(nullable: true)
    }
}
