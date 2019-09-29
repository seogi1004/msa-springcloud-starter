package com.brownfield.booking.component

import java.util.Date
import java.util.HashMap

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

import com.brownfield.booking.entity.BookingRecord
import com.brownfield.booking.repository.BookingRepository
import com.brownfield.booking.repository.InventoryRepository

@Component
class BookingComponent @Autowired
constructor(internal var bookingRepository: BookingRepository,
            internal var sender: Sender, internal var inventoryRepository: InventoryRepository) {

    //@Autowired
    //	private RestTemplate restTemplate;

    private val webClient: WebClient

    init {
        //this.restTemplate = new RestTemplate();
        this.webClient = WebClient.create(FareURL)
    }

    fun book(record: BookingRecord): Long {
        logger.info("calling fares to get fare")
        //call fares to get fare
        //Fare fare = restTemplate.getForObject(FareURL +"/get?flightNumber="+record.getFlightNumber()+"&flightDate="+record.getFlightDate(),Fare.class);

        //Fare fare = restTemplate.getForObject(FareURL +"/get?flightNumber="+record.getFlightNumber()+"&flightDate="+record.getFlightDate(),Fare.class);

        validateFareReactively(record)

        //check fare
        logger.info("calling inventory to get inventory")
        //check inventory
        val inventory = inventoryRepository.findByFlightNumberAndFlightDate(record.flightNumber!!, record.flightDate!!)
        if (!inventory.isAvailable(record.passengers!!.size)) {
            throw BookingException("No more seats avaialble")
        }
        logger.info("successfully checked inventory$inventory")
        logger.info("calling inventory to update inventory")
        //update inventory
        inventory.available = inventory.available - record.passengers!!.size
        inventoryRepository.saveAndFlush(inventory)
        logger.info("sucessfully updated inventory")
        //save booking
        record.status = BookingStatus.BOOKING_CONFIRMED
        val passengers = record.passengers
        passengers!!.forEach { passenger -> passenger.bookingRecord = record }
        record.bookingDate = Date()
        val id = bookingRepository.save(record).id
        logger.info("Successfully saved booking")
        //send a message to search to update inventory
        logger.info("sending a booking event")
        val bookingDetails = HashMap<String, Any>()
        bookingDetails["FLIGHT_NUMBER"] = record.flightNumber!!
        bookingDetails["FLIGHT_DATE"] = record.flightDate!!
        bookingDetails["NEW_INVENTORY"] = inventory.bookableInventory
        sender.send(bookingDetails)
        logger.info("booking event successfully delivered $bookingDetails")
        return id
    }

    fun getBooking(id: Long): BookingRecord {
        return bookingRepository.findById(id).get()
    }


    fun updateStatus(status: String, bookingId: Long) {
        val record = bookingRepository.findById(bookingId).get()
        record.status = status
    }

    fun validateFareReactively(record: BookingRecord) {
        val result = webClient.get()
                .uri("/fares/get?flightNumber=" + record.flightNumber + "&flightDate=" + record.flightDate)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap { response -> response.bodyToMono(Fare::class.java) }
        result.subscribe { fare -> checkFare(record.fare!!, fare.fare) }

    }

    private fun checkFare(requestedFare: String, actualfare: String) {
        logger.info("calling fares to get fare (reactively collected) $actualfare")
        if (requestedFare != actualfare)
            throw BookingException("fare is tampered")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(BookingComponent::class.java)
        private val FareURL = "http://fares-apigateway/api"
    }
}
