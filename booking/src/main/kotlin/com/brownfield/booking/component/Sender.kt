package com.brownfield.booking.component

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component


@RefreshScope
@Component
@EnableBinding(BookingSource::class)
class Sender {

    /**	RabbitMessagingTemplate template;
     *
     * @Autowired
     * Sender(RabbitMessagingTemplate template){
     * this.template = template;
     * }
     * @Bean
     * Queue queue() {
     * return new Queue("InventoryQ", false);
     * }
     * @Bean
     * Queue queue1() {
     * return new Queue("CheckInQ", false);
     * }
     */

    @Output(BookingSource.InventoryQ)
    @Autowired
    private val messageChannel: MessageChannel? = null

    fun send(message: Any) {
        //template.convertAndSend("InventoryQ", message);
        messageChannel!!.send(MessageBuilder.withPayload(message).build())
    }
}

internal interface BookingSource {
    @Output("inventoryQ")
    fun inventoryQ(): MessageChannel

    companion object {
        const val InventoryQ = "inventoryQ"
    }

}