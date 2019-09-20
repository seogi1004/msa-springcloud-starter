package com.brownfield.configserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class ConfigserverApplication

fun main(args: Array<String>) {
    runApplication<ConfigserverApplication>(*args)
}
