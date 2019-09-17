package com.brownfield.checkin.repository

import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.checkin.entity.CheckInRecord

interface CheckinRepository : JpaRepository<CheckInRecord, Long>
