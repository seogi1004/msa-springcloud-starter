package com.brownfield.fares

import java.util.Arrays
import java.util.stream.Collectors

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication

import com.brownfield.fares.entity.Fare
import com.brownfield.fares.repository.FaresRepository
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class FaresApplication : CommandLineRunner {
    @Autowired
    internal var faresRepository: FaresRepository? = null

    @Throws(Exception::class)
    override fun run(vararg strings: String) {
        val fares = arrayOf(Fare("BF100", "22-JAN-18", "101"), Fare("BF101", "22-JAN-18", "101"), Fare("BF102", "22-JAN-18", "102"), Fare("BF103", "22-JAN-18", "103"), Fare("BF104", "22-JAN-18", "104"), Fare("BF105", "22-JAN-18", "105"), Fare("BF106", "22-JAN-18", "106"))
        val list = Arrays.stream(fares).collect(Collectors.toList())
        list.forEach { fare -> faresRepository!!.save(fare) }

        logger.info("Result: " + faresRepository!!.getFareByFlightNumberAndFlightDate("BF101", "22-JAN-18"))
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FaresApplication::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<FaresApplication>(*args)
}