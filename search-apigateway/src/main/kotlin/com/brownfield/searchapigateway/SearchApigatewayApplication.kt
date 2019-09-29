package com.brownfield.searchapigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
class SearchApigatewayApplication

fun main(args: Array<String>) {
    runApplication<SearchApigatewayApplication>(*args)
}
