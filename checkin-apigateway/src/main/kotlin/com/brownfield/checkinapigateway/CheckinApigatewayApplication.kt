package com.brownfield.checkinapigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
class CheckinApigatewayApplication

fun main(args: Array<String>) {
    runApplication<CheckinApigatewayApplication>(*args)
}
