package net.mono0x. springsecuritytest.security

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken

class MyUserDetailsService : AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {
    /**
     *
     * @param token The pre-authenticated authentication token
     * @return UserDetails for the given authentication token, never null.
     * @throws UsernameNotFoundException if no user details can be found for the given
     * authentication token
     */
    override fun loadUserDetails(token: PreAuthenticatedAuthenticationToken?): UserDetails {
        return MyUserDetails((token?.principal ?: UsernameNotFoundException("")) as String)
    }
}