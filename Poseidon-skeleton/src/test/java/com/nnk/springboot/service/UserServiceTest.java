package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testGetUsers() {
        // Arrange
        User user1 = new User();
        User user2 = new User();
        List<User> expectedUsers = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(expectedUsers);

        // Act
        List<User> actualUsers = userService.getUsers();

        // Assert
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    public void testGetUserById() {
        // Arrange
        User user = new User();
        int userId = 1;
        when(userRepository.existsById(userId)).thenReturn(true);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        Optional<User> actualUser = userService.getUserById(userId);

        // Assert
        assertTrue(actualUser.isPresent());
        assertEquals(user, actualUser.get());
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void testAddUser() {
        // Arrange
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setFullname("TestFullname");
        user.setRole("ROLE_USER");
        when(userRepository.isUsernameUnique(user.getUsername())).thenReturn(0);
        when(passwordEncoder.encode(user.getPassword())).thenReturn("testPassword");
        when(userRepository.save(user)).thenReturn(user);

        // Act
        User actualUser = userService.addUser(user);

        // Assert
        assertEquals(user, actualUser);
        assertEquals("testPassword", actualUser.getPassword());
    }

    @Test
    public void deleteUserByIdTest() {
        // Arrange
        int userId = 1;

        // Act
        userRepository.deleteById(userId);

        // Assert
        verify(userRepository, Mockito.times(1)).deleteById(any());
    }
}