package net.mono0x.springsecuritytest.configuration

import net.mono0x.springsecuritytest.security.MyPreAuthenticatedFilter
import net.mono0x.springsecuritytest.security.MyUserDetailsService
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider

@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(auth: AuthenticationManagerBuilder?) {
        //super.configure(auth)

        val provider = PreAuthenticatedAuthenticationProvider()
        provider.setPreAuthenticatedUserDetailsService(MyUserDetailsService())
        auth!!.authenticationProvider(provider)
    }

    override fun configure(http: HttpSecurity?) {
        //super.configure(http)

        val filter = MyPreAuthenticatedFilter()
        filter.setAuthenticationManager(authenticationManager())

        http!!.addFilter(filter)
                .authorizeRequests()
                .mvcMatchers("/edit").hasAuthority("EDIT")
                .mvcMatchers("/create").hasAuthority("CREATE")
                .mvcMatchers("/not_authorized").hasAuthority("NOT_AUTHORIZED")
                .mvcMatchers("/").permitAll()
                .anyRequest().denyAll()
    }
}
