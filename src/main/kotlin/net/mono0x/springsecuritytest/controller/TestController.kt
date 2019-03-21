package net.mono0x.springsecuritytest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    @GetMapping("/")
    fun index(): String {
        return "OK"
    }
}