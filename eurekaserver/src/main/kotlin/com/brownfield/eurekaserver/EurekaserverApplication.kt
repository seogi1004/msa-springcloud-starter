package com.brownfield.eurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaserverApplication

fun main(args: Array<String>) {
    runApplication<EurekaserverApplication>(*args)
}
