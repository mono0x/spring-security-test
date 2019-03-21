package net.mono0x.springsecuritytest.security

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter
import javax.servlet.http.HttpServletRequest

class MyPreAuthenticatedFilter : AbstractPreAuthenticatedProcessingFilter() {
    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest?): Any {
        return "admin"
    }

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
        return "" // N/A
    }
}