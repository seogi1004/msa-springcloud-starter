package com.brownfield.checkin.component

import java.util.Date

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.brownfield.checkin.entity.CheckInRecord
import com.brownfield.checkin.repository.CheckinRepository

@Component
class CheckinComponent @Autowired
internal constructor(internal var checkinRepository: CheckinRepository, internal var sender: Sender) {

    fun checkIn(checkIn: CheckInRecord): Long {
        checkIn.checkInTime = Date()
        logger.info("Saving checkin ")
        //save
        val id = checkinRepository.save(checkIn).id
        logger.info("Successfully saved checkin ")
        //send a message back to booking to update status
        logger.info("Sending booking id $id")
        sender.send(id)
        return id
    }

    fun getCheckInRecord(id: Long): CheckInRecord {
        return checkinRepository.findById(id).get()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CheckinComponent::class.java)
    }

}	
