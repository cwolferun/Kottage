package com.kottage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KottageApplication

fun main(args: Array<String>) {

	runApplication<KottageApplication>(*args)
}
