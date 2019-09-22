package com.brownfield.search

import java.util.ArrayList

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.brownfield.search.entity.Fares
import com.brownfield.search.entity.Flight
import com.brownfield.search.entity.Inventory
import com.brownfield.search.repository.FlightRepository
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class SearchApplication : CommandLineRunner {

    @Autowired
    private val flightRepository: FlightRepository? = null

    @Throws(Exception::class)
    override fun run(vararg strings: String) {
        val flights = ArrayList<Flight>()
        flights.add(Flight("BF100", "SEA", "SFO", "22-JAN-18", Fares("100", "USD"), Inventory(100)))
        flights.add(Flight("BF101", "NYC", "SFO", "22-JAN-18", Fares("101", "USD"), Inventory(100)))
        flights.add(Flight("BF105", "NYC", "SFO", "22-JAN-18", Fares("105", "USD"), Inventory(100)))
        flights.add(Flight("BF106", "NYC", "SFO", "22-JAN-18", Fares("106", "USD"), Inventory(100)))
        flights.add(Flight("BF102", "CHI", "SFO", "22-JAN-18", Fares("102", "USD"), Inventory(100)))
        flights.add(Flight("BF103", "HOU", "SFO", "22-JAN-18", Fares("103", "USD"), Inventory(100)))
        flights.add(Flight("BF104", "LAX", "SFO", "22-JAN-18", Fares("104", "USD"), Inventory(100)))

        flightRepository!!.saveAll(flights)

        logger.info("Looking to load flights...")
        for (flight in flightRepository.findByOriginAndDestinationAndFlightDate("NYC", "SFO", "22-JAN-18")) {
            logger.info(flight.toString())
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SearchApplication::class.java)

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SearchApplication::class.java, *args)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SearchApplication>(*args)
}
