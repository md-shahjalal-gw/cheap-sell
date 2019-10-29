package com.cheapsell.product

import com.cheapsell.user.Login
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Item implements Serializable {

    private static final long serialVersionUID = 1

    String name
    int askingPrice
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
    Login createdBy

    static mapping = {
        createdBy lazy: false
    }

    static constraints = {
    }
}
