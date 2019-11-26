package com.cheapsell.product

import com.budjb.rabbitmq.consumer.MessageContext

class WishListConsumer {

    ItemEmailService itemEmailService

    static rabbitConfig = [
            queue: "wishList"
    ]

    /**
     * Handle an incoming RabbitMQ message.
     *
     * @param body The converted body of the incoming message.
     * @param context Properties of the incoming message.
     * @return
     */
    def handleMessage(Map body, MessageContext messageContext) {
        itemEmailService.sendAvailableNotification(body.name, body.price, body.id)
    }
}
