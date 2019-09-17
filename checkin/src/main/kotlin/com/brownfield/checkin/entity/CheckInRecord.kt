package com.brownfield.checkin.entity

import java.util.Date

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class CheckInRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var lastName: String = ""
    var firstName: String = ""
    var seatNumber: String = ""
    var checkInTime: Date? = null
    var flightNumber: String = ""
    var flightDate: String = ""
    var bookingId: Long = 0

    constructor() {

    }

    constructor(lastName: String, firstName: String, seatNumber: String, checkInTime: Date, flightNumber: String,
                flightDate: String, bookingId: Long) : super() {
        this.lastName = lastName
        this.firstName = firstName
        this.seatNumber = seatNumber
        this.checkInTime = checkInTime
        this.flightNumber = flightNumber
        this.flightDate = flightDate
        this.bookingId = bookingId
    }

    override fun toString(): String {
        return ("CheckInRecord [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", seatNumber="
                + seatNumber + ", checkInTime=" + checkInTime + ", flightNumber=" + flightNumber + ", flightDate="
                + flightDate + "]")
    }


}
