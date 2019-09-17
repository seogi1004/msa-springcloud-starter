package com.brownfield.booking.controller

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.brownfield.booking.component.BookingComponent
import com.brownfield.booking.component.BookingStatus

@Component
class Receiver @Autowired
constructor(internal var bookingComponent: BookingComponent) {
    @RabbitListener(queues = ["CheckINQ"])
    fun processMessage(bookingID: Long) {
        println(bookingID)
        bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID)
    }

}