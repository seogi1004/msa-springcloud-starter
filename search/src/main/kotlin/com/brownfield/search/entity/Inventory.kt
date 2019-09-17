package com.brownfield.search.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id")
    var id: Long = 0

    var count: Int = 0

    constructor() : super() {}

    constructor(count: Int) : super() {
        this.count = count
    }

    override fun toString(): String {
        return "Inventory [id=$id, count=$count]"
    }
}
