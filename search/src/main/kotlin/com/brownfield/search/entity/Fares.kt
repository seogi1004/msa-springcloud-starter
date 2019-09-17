package com.brownfield.search.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Fares {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fare_id")
    var id: Long = 0

    var fare: String = ""
    var currency: String = ""


    constructor(fare: String, currency: String) : super() {
        this.fare = fare
        this.currency = currency
    }

    constructor() : super() {}

    override fun toString(): String {
        return "Fares [id=$id, fare=$fare, currency=$currency]"
    }


}
