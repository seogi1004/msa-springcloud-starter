package com.brownfield.checkin.component

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@EnableBinding(CheckInSource::class)
@Component
class Sender {

    /**
     * RabbitMessagingTemplate template;
     *
     * @Autowired
     * Sender(RabbitMessagingTemplate template){
     * this.template = template;
     * }
     * @Bean
     * Queue queue() {
     * return new Queue("CheckInQ", false);
     * }
     *
     * public void send(Object message){
     * template.convertAndSend("CheckInQ", message);
     * }
     */

    @Output(CheckInSource.CheckInQ)
    @Autowired
    private val messageChannel: MessageChannel? = null

    fun send(message: Any) {
        //template.convertAndSend("InventoryQ", message);
        messageChannel!!.send(MessageBuilder.withPayload(message).build())
    }
}

internal interface CheckInSource {
    @Output("checkInQ")
    fun checkInQ(): MessageChannel

    companion object {
        const val CheckInQ = "checkInQ"
    }
}