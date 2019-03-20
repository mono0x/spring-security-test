package net.mono0x.springsecuritytest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSecurityTestApplication

fun main(args: Array<String>) {
    runApplication<SpringSecurityTestApplication>(*args)
}
