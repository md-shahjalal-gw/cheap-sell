package com.cheapsell.product

import com.cheapsell.user.Login

class Item implements Serializable {

    private static final long serialVersionUID = 1

    long id
    long version

    String name
    int askingPrice
    boolean negotiable
    ShippingOption shippingOption
    Condition condition;
    Usage usage
    String description
    int weight
    String color
    String material

    Login createdBy
    Date createDate
    Login updatedBy
    Date updateDate

    static constraints = {
    }
}
