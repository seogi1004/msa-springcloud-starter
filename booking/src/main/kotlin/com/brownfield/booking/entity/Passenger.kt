package com.brownfield.booking.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var firstName: String = ""
    var lastName: String = ""
    var gender: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKING_ID")
    @JsonIgnore
    var bookingRecord: BookingRecord? = null

    constructor() {}

    constructor(firstName: String, lastName: String, gender: String, bookingRecord: BookingRecord) {
        this.firstName = firstName
        this.lastName = lastName
        this.gender = gender
        this.bookingRecord = bookingRecord
    }

    override fun toString(): String {
        return "Passenger [id=$id, firstName=$firstName, lastName=$lastName, gender=$gender]"
    }
}
