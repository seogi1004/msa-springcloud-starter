package com.brownfield.fares.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var flightNumber: String = ""
    var flightDate: String = ""
    var fare: String = ""

    constructor() : super() {}

    constructor(flightNumber: String, flightDate: String, fare: String) : super() {
        this.flightNumber = flightNumber
        this.flightDate = flightDate
        this.fare = fare
    }


    override fun toString(): String {
        return ("Fares [id=" + id + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", fare=" + fare
                + "]")
    }
}
