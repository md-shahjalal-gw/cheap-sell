package com.cheapsell.product

import com.cheapsell.user.Login
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Item implements Serializable {

    private static final long serialVersionUID = 1

    String name
    int price
    Integer originalPrice
    boolean negotiable
    ShippingOption shippingOption
    ItemCondition itemCondition;
    Date purchaseDate
    ItemUsage itemUsage
    String description
    int weight
    String color
    String material
    boolean sold

    Date createDate
    Date updateDate

    byte[] imageBytes
    String imageName
    String imageContentType


    static belongsTo = [login:Login]

    static constraints = {
        name(size: 3..100)
        price(min: 0, max: 100)
        originalPrice(nullable: true)
        negotiable()
        color(nullable: true)
        weight(nullable: true)
        material(size: 2..50)
        itemUsage()
        itemCondition()
        description(nullable: true, size: 5..200)
        shippingOption()
        updateDate(nullable: true)
        purchaseDate(nullable: true)

        imageBytes(nullable: true, maxSize:26214400)
        imageContentType(nullable: true, blank: true)
        imageName(blank:true, nullable:true)
    }
}
