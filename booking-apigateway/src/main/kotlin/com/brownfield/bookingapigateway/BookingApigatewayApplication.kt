package com.brownfield.bookingapigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
class BookingApigatewayApplication

fun main(args: Array<String>) {
    runApplication<BookingApigatewayApplication>(*args)
}
