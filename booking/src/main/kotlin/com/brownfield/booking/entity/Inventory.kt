package com.brownfield.booking.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var flightNumber: String = ""
    var flightDate: String = ""
    var available: Int = 0

    val bookableInventory: Int
        get() = available - 5

    constructor(flightNumber: String, flightDate: String, available: Int) : super() {
        this.flightNumber = flightNumber
        this.flightDate = flightDate
        this.available = available
    }

    constructor() {}

    fun isAvailable(count: Int): Boolean {
        return available - count > 5
    }

    override fun toString(): String {
        return ("Inventory [id=" + id + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", available="
                + available + "]")
    }
}