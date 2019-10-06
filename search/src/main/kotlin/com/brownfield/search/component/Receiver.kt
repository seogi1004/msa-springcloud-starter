package com.brownfield.search.component

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.Input
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.messaging.MessageChannel
import org.springframework.stereotype.Component

@Component
@EnableBinding(SearchSink::class)
class Receiver {

    @Autowired
    internal var searchComponent: SearchComponent? = null

    /**
     *
     * public Receiver(SearchComponent searchComponent){
     * this.searchComponent = searchComponent;
     * }
     * @Bean
     * Queue queue() {
     * return new Queue("InventoryQ", false);
     * }
     * @RabbitListener(queues = "InventoryQ")
     * public void processMessage(Map<String></String>,Object> fare) {
     * searchComponent.updateInventory((String)fare.get("FLIGHT_NUMBER"),(String)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
     * //call repository and update the fare for the given flight
     * }
     */

    @ServiceActivator(inputChannel = SearchSink.InventoryQ)
    fun accept(fare: Map<String, Any>) {
        searchComponent!!.updateInventory(
                fare["FLIGHT_NUMBER"] as String,
                fare["FLIGHT_DATE"] as String,
                fare["NEW_INVENTORY"] as Int
        )
    }
}

internal interface SearchSink {
    @Input("inventoryQ")
    fun inventoryQ(): MessageChannel

    companion object {
        const val InventoryQ = "inventoryQ"
    }
}