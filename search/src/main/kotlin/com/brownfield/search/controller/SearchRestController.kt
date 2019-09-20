package com.brownfield.search.controller

import org.springframework.beans.factory.annotation.Autowired

import com.brownfield.search.component.SearchComponent
import com.brownfield.search.entity.Flight
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*
import java.util.*

@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
internal class SearchRestController @Autowired
constructor(private val searchComponent: SearchComponent) {
    private val logger = LoggerFactory.getLogger(SearchComponent::class.java)

    @Value("\${originairports.shutdown}")
    lateinit var originAirportShutdownList: String

    @GetMapping("/config")
    fun config(): String {
        return originAirportShutdownList
    }

    @PostMapping("/get")
    fun search(@RequestBody query: SearchQuery): List<Flight> {
        logger.info("Input : $query, Origin : $originAirportShutdownList")
        if (originAirportShutdownList.split(",").contains(query.origin)) {
            logger.info("The origin airport is in shutdown state")
            return ArrayList()
        }

        return searchComponent.search(query)
    }
}
