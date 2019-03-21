package net.mono0x.springsecuritytest.controller

import net.mono0x.springsecuritytest.security.MyUserDetails
import org.slf4j.LoggerFactory
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {
    companion object {
        private val log = LoggerFactory.getLogger(TestController::class.java)
    }

    @GetMapping("/")
    fun index(@AuthenticationPrincipal principal: MyUserDetails?): String {
        log.info("{}", principal?.username)
        return "OK"
    }

    @GetMapping("/edit")
    fun edit(@AuthenticationPrincipal principal: MyUserDetails?): String {
        log.info("{}", principal?.username)
        return "OK"
    }

    @GetMapping("/create")
    fun create(@AuthenticationPrincipal principal: MyUserDetails?): String {
        log.info("{}", principal?.username)
        return "OK"
    }

    @GetMapping("/not_authorized")
    fun notAuthorized(@AuthenticationPrincipal principal: MyUserDetails?): String {
        log.info("{}", principal?.username)
        return "OK"
    }
}