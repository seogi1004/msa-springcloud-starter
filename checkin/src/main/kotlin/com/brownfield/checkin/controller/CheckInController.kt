package com.brownfield.checkin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.brownfield.checkin.component.CheckinComponent
import com.brownfield.checkin.entity.CheckInRecord

@RestController
@CrossOrigin
@RequestMapping("/checkin")
class CheckInController @Autowired
internal constructor(internal var checkInComponent: CheckinComponent) {

    @RequestMapping("/get/{id}")
    internal fun getCheckIn(@PathVariable id: Long): CheckInRecord {
        return checkInComponent.getCheckInRecord(id)
    }

    @RequestMapping(value = ["/create"], method = [RequestMethod.POST])
    internal fun checkIn(@RequestBody checkIn: CheckInRecord): Long {
        return checkInComponent.checkIn(checkIn)
    }

}
