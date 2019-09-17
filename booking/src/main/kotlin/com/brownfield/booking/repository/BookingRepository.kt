package com.brownfield.booking.repository


import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.booking.entity.BookingRecord

interface BookingRepository : JpaRepository<BookingRecord, Long>
