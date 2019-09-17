package com.brownfield.pss.booking.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.brownfield.pss.booking.component.BookingComponent
import com.brownfield.pss.booking.entity.BookingRecord

@RestController
@CrossOrigin
@RequestMapping("/booking")
class BookingController @Autowired
internal constructor(internal var bookingComponent: BookingComponent) {

    @RequestMapping(value = ["/create"], method = [RequestMethod.POST])
    internal fun book(@RequestBody record: BookingRecord): Long {
        println("Booking Request$record")
        return bookingComponent.book(record)
    }

    @RequestMapping("/get/{id}")
    internal fun getBooking(@PathVariable id: Long): BookingRecord {
        return bookingComponent.getBooking(id)
    }
}
