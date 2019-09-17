package com.brownfield.pss.booking.repository


import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.booking.entity.BookingRecord

interface BookingRepository : JpaRepository<BookingRecord, Long>
