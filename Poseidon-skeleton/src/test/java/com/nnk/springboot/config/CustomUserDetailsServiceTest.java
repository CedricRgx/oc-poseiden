package com.nnk.springboot.config;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Test
    void testLoadUserByUsername_UserFoundAndActive_ReturnsUserDetails() {
        // Arrange
        String username = "usernameTest";
        User mockUser = new User(username, "passwordTest", "fullnameTest", "roleTest");

        // Act
        when(userService.findByUsername(username)).thenReturn(Optional.of(mockUser));
        UserDetails result = customUserDetailsService.loadUserByUsername(username);

        // Assert
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertTrue(result.isEnabled());
    }

}
