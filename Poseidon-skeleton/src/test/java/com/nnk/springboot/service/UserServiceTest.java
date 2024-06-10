package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.impl.UserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        user.setRole("USER");

        User savedUser = new User();
        savedUser.setUsername("testUser");
        savedUser.setPassword("testPassword");
        savedUser.setFullname("TestFullname");
        savedUser.setRole("USER");

        when(userRepository.isUsernameUnique(user.getUsername())).thenReturn(0);
        when(passwordEncoder.encode(user.getPassword())).thenReturn("hashedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        User actualUser = userService.addUser(user);

        // Assert
        assertEquals(user, actualUser);
    }

    @Test
    public void testAddUser_UsernameAlreadyExists() {
        // Arrange
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");
        user.setFullname("TestFullname");
        user.setRole("USER");

        when(userRepository.isUsernameUnique(user.getUsername())).thenReturn(1);

        // Act & Assert
        EntityExistsException exception = assertThrows(EntityExistsException.class, () -> {
            userService.addUser(user);
        });

        assertEquals("Username already exists", exception.getMessage());
    }

    @Test
    public void testUpdateUser() {
        // Arrange
        int existentUserId = 1;
        int nonExistentUserId = 2;
        User existentUser = new User();
        existentUser.setId(existentUserId);
        existentUser.setUsername("ExistUser");
        User nonExistentUser = new User();
        nonExistentUser.setId(nonExistentUserId);
        nonExistentUser.setUsername("NonExistUser");

        // // Act
        when(userRepository.existsById(existentUserId)).thenReturn(true);
        when(userRepository.existsById(nonExistentUserId)).thenReturn(false);
        when(userRepository.save(existentUser)).thenReturn(existentUser);

        // Arrange
        assertDoesNotThrow(() -> userService.updateUser(existentUser));
        assertThrows(EntityNotFoundException.class, () -> userService.updateUser(nonExistentUser));
    }


    @Test
    public void testDeleteUserById(){
        // Arrange
        int existentUserId = 1;
        int nonExistentUserId = 2;

        // Act
        when(userRepository.existsById(existentUserId)).thenReturn(true);
        when(userRepository.existsById(nonExistentUserId)).thenReturn(false);

        // Assert
        assertDoesNotThrow(() -> userService.deleteUserById(existentUserId));
        verify(userRepository, times(1)).deleteById(existentUserId);
        assertThrows(EntityNotFoundException.class, () -> userService.deleteUserById(nonExistentUserId));
        verify(userRepository, times(0)).deleteById(nonExistentUserId);
    }

    @Test
    public void testIsUsernameUnique() {
        // Arrange
        String uniqueUsername = "UniqueUser";
        String duplicateUsername = "DuplicateUser";

        // Act
        when(userRepository.isUsernameUnique(uniqueUsername)).thenReturn(0);
        when(userRepository.isUsernameUnique(duplicateUsername)).thenReturn(1);

        // Assert
        assertTrue(userService.isUsernameUnique(uniqueUsername));
        assertFalse(userService.isUsernameUnique(duplicateUsername));
    }

    @Test
    public void testVerifyUserExistence() {
        // Arrange
        int existentUserId = 1;
        int nonExistentUserId = 2;

        // Act
        when(userRepository.existsById(existentUserId)).thenReturn(true);
        when(userRepository.existsById(nonExistentUserId)).thenReturn(false);

        // Assert
        assertDoesNotThrow(() -> userService.verifyUserExistence(existentUserId));
        assertThrows(PoseidonEntityNotFoundException.class, () -> userService.verifyUserExistence(nonExistentUserId));
    }
}