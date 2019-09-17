package com.brownfield.search.entity

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    var flightNumber: String = ""
    var origin: String = ""
    var destination: String = ""
    var flightDate: String = ""

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "fare_Id")
    var fares: Fares? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "inv_Id")
    var inventory: Inventory? = null


    constructor() : super() {}


    constructor(flightNumber: String, origin: String, destination: String, flightDate: String, fares: Fares,
                inventory: Inventory) : super() {
        this.flightNumber = flightNumber
        this.origin = origin
        this.destination = destination
        this.flightDate = flightDate
        this.fares = fares
        this.inventory = inventory
    }

    override fun toString(): String {
        return ("Flight [id=" + id + ", flightNUmber=" + flightNumber + ", origin=" + origin + ", destination="
                + destination + ", flightDate=" + flightDate + ", fares=" + fares + ", inventory=" + inventory + "]")
    }


}
