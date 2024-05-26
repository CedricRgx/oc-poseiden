package com.nnk.springboot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

/**
 * Implements the AuthenticationSuccessHandler interface from Spring Security
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * This method is called when the user successfully authenticates. It checks the user's role.
     *
     * @param request        The HttpServletRequest, which is used to enable request-specific features.
     * @param response       The HttpServletResponse, which assists in sending a response to the client.
     * @param authentication The successful Authentication object from the attempt to authenticate.
     * @throws IOException            If the redirection process encounters an issue
     * @throws IllegalStateException  If the granted authority doesn't match expected roles (i.e., "ROLE_USER", "ROLE_ADMIN")
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                redirectStrategy.sendRedirect(request, response, "/bidList/list");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                redirectStrategy.sendRedirect(request, response, "/home");
                break;
            } else {
                throw new IllegalStateException();
            }
        }
    }

}