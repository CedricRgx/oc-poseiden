package com.nnk.springboot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension .class)
public class SpringSecurityConfigTest {

    @InjectMocks
    private SpringSecurityConfig springSecurityConfig;

    @Test
    public void testPasswordEncoder() {
        // Arrange Act
        BCryptPasswordEncoder result = springSecurityConfig.passwordEncoder();

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testCustomAuthenticationSuccessHandler() {
        // Arrange Act
        AuthenticationSuccessHandler result = springSecurityConfig.customAuthenticationSuccessHandler();

        // Assert
        assertNotNull(result);
    }

}
