package com.brownfield.search.controller

import org.springframework.beans.factory.annotation.Autowired

import com.brownfield.search.component.SearchComponent
import com.brownfield.search.entity.Flight
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/search")
internal class SearchRestController @Autowired
constructor(private val searchComponent: SearchComponent) {

    @PostMapping("/get")
    fun search(@RequestBody query: SearchQuery): List<Flight> {
        println("Input : $query")
        return searchComponent.search(query)
    }

}
