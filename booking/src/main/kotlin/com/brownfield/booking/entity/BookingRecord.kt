package com.brownfield.booking.entity

import java.util.Date

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class BookingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var flightNumber: String? = null
    var origin: String? = null
    var destination: String? = null
    var flightDate: String? = null
    var bookingDate: Date? = null
    var fare: String? = null
    var status: String? = null

    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], mappedBy = "bookingRecord")
    var passengers: Set<Passenger>? = null

    constructor() {}

    constructor(flightNumber: String, from: String, to: String,
                flightDate: String, bookingDate: Date, fare: String) {
        this.flightNumber = flightNumber
        this.origin = from
        this.destination = to
        this.flightDate = flightDate
        this.bookingDate = bookingDate
        this.fare = fare
        this.status = status
    }

    override fun toString(): String {
        return ("BookingRecord [id=" + id + ", flightNumber=" + flightNumber + ", from=" + origin + ", to=" + destination
                + ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", passengers=" + passengers
                + "]")
    }
}
