package com.nnk.springboot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomAuthenticationSuccessHandlerTest {

    @Mock
    private DefaultRedirectStrategy defaultRedirectStrategy;

    @InjectMocks
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Test
    public void testOnAuthenticationSuccessUser() throws IOException {
        // Arrange
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();
        String authority = "ROLE_USER";
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken("user", "pass", Collections.singletonList(new SimpleGrantedAuthority(authority)));

        // Act
        customAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication);

        // Assert
        verify(defaultRedirectStrategy).sendRedirect(request, response, "/bidList/list");
    }

    @Test
    public void testOnAuthenticationSuccessAdmin() throws IOException {
        // Arrange
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();
        String authority = "ROLE_ADMIN";
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken("user", "pass", Collections.singletonList(new SimpleGrantedAuthority(authority)));

        // Act
        customAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication);

        // Assert
        verify(defaultRedirectStrategy).sendRedirect(request, response, "/");
    }

    @Test
    public void testOnAuthenticationSuccessException() {
        // Arrange
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();
        String authority = "ROLE_NON_EXISTING";
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken("user", "pass", Collections.singletonList(new SimpleGrantedAuthority(authority)));

        // Act Assert
        assertThrows(IllegalStateException.class, () ->
                customAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication));
    }

    @Test
    public void testMultipleAuthorities() throws IOException {
        // Arrange
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("username", "password", authorities);

        // Act
        customAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authenticationToken);
    }



}
