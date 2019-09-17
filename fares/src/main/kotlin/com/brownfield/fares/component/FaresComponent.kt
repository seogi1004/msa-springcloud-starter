package com.brownfield.fares.component

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import com.brownfield.fares.entity.Fare
import com.brownfield.fares.repository.FaresRepository

@Component
class FaresComponent {
    internal lateinit var faresRepository: FaresRepository

    constructor() {}

    @Autowired
    constructor(faresRepository: FaresRepository) {
        this.faresRepository = faresRepository
    }

    fun getFare(flightNumber: String, flightDate: String): Fare {
        logger.info("Looking for fares flightNumber $flightNumber flightDate $flightDate")
        return faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(FaresComponent::class.java!!)
    }
}
