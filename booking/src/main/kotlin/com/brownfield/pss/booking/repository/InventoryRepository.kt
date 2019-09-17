package com.brownfield.pss.booking.repository


import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.booking.entity.Inventory

interface InventoryRepository : JpaRepository<Inventory, Long> {
    fun findByFlightNumberAndFlightDate(flightNumber: String, flightDate: String): Inventory
}
