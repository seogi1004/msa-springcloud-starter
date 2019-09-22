package com.brownfield.booking

import java.util.Arrays
import java.util.Date
import java.util.HashSet

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.brownfield.booking.component.BookingComponent
import com.brownfield.booking.entity.BookingRecord
import com.brownfield.booking.entity.Inventory
import com.brownfield.booking.entity.Passenger
import com.brownfield.booking.repository.BookingRepository
import com.brownfield.booking.repository.InventoryRepository
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class BookingApplication : CommandLineRunner {
    @Autowired
    private val bookingRepository: BookingRepository? = null

    @Autowired
    private val bookingComponent: BookingComponent? = null

    @Autowired
    internal var inventoryRepository: InventoryRepository? = null

    @Throws(Exception::class)
    override fun run(vararg strings: String) {

        val invs = arrayOf(Inventory("BF100", "22-JAN-18", 100), Inventory("BF101", "22-JAN-18", 100), Inventory("BF102", "22-JAN-18", 100), Inventory("BF103", "22-JAN-18", 100), Inventory("BF104", "22-JAN-18", 100), Inventory("BF105", "22-JAN-18", 100), Inventory("BF106", "22-JAN-18", 100))
        Arrays.asList(*invs).forEach { inventory -> inventoryRepository!!.save(inventory) }


        val booking = BookingRecord("BF101", "NYC", "SFO", "22-JAN-18", Date(), "101")
        val passengers = HashSet<Passenger>()
        passengers.add(Passenger("Gean", "Franc", "Male", booking))
        //	passengers.add(new Passenger("Redi","Ivan","Female",booking));

        booking.passengers = passengers
        val record = bookingComponent!!.book(booking)
        logger.info("Booking successfully saved...$record")

        logger.info("Looking to load booking record...")
        logger.info("Result: " + bookingComponent.getBooking(record))
    }

    companion object {
        private val logger = LoggerFactory.getLogger(BookingApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<BookingApplication>(*args)
}