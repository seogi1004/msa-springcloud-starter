package com.brownfield.fares.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import com.brownfield.fares.component.FaresComponent
import com.brownfield.fares.entity.Fare

@RestController
@CrossOrigin
@RequestMapping("/fares")
class FaresController @Autowired
internal constructor(internal var faresComponent: FaresComponent) {

    @RequestMapping("/get")
    internal fun getFare(@RequestParam(value = "flightNumber") flightNumber: String, @RequestParam(value = "flightDate") flightDate: String): Fare {
        return faresComponent.getFare(flightNumber, flightDate)
    }
}
