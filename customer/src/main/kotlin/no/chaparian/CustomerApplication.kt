package no.chaparian

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerApplication
    fun main(args: Array<String>) {
        runApplication<CustomerApplication>(*args)

    }
