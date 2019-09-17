package com.brownfield.search.component

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Receiver @Autowired
constructor(internal var searchComponent: SearchComponent) {
    @Bean
    internal fun queue(): Queue {
        return Queue("SearchQ", false)
    }

    @RabbitListener(queues = ["SearchQ"])
    fun processMessage(fare: Map<String, Any>) {
        println(fare)
        searchComponent.updateInventory(fare["FLIGHT_NUMBER"] as String, fare["FLIGHT_DATE"] as String, fare["NEW_INVENTORY"] as Int)
        //call repository and update the fare for the given flight
    }
}