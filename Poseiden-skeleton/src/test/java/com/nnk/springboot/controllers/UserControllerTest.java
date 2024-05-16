package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers_UserExists_ShouldReturnFound() {
        // Arrange
        User userOne = new User(1, "John Doe", "JohnDoe", "password", "USER");
        User userTwo = new User(2, "Jane Doe", "JaneDoe", "password", "USER");
        List<User> users = Arrays.asList(userOne, userTwo);
        when(userService.getUsers()).thenReturn(users);

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testGetAllUsers_NoUserExists_ShouldReturnNotFound() {
        // Arrange
        when(userService.getUsers()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void testGetUserById_UserExists_ShouldReturnFound() {
        // Arrange
        User user = new User(1, "John Doe", "JohnDoe", "password", "USER");
        when(userService.getUserById(1)).thenReturn(Optional.of(user));

        // Act
        ResponseEntity<User> response = userController.getUserById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void getUserById_UserDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        Integer userId = 1;
        when(userService.getUserById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<User> response;
        response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testAddNewUser_userAddedSuccessfully_shouldReturnStatusCreated() {
        // Arrange
        User user = new User(1, "John Doe", "JohnDoe", "password", "USER");
        when(userService.addUser(user)).thenReturn(user);

        // Act
        ResponseEntity<User> response = userController.addNewUser(user);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testAddNewUser_userAddedFailure_shouldReturnStatusBadRequest() {
        // Arrange
        User user = new User(1, "John Doe", "JohnDoe", "password", "USER");
        when(userService.addUser(user)).thenReturn(null);

        // Act
        ResponseEntity<User> response = userController.addNewUser(user);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateUser_userUpdatedSuccessfully_shouldReturnStatusOk() {
        // Arrange
        User user = new User(1, "John Doe", "JohnDoe", "password", "USER");
        when(userService.updateUser(user)).thenReturn(user);

        // Act
        ResponseEntity<User> response = userController.updateUser(user.getUserId(), user);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService).updateUser(user);
    }

    @Test
    public void testUpdateUser_userUpdateFailure_shouldReturnStatusNotFound() {
        // Arrange
        User user = new User(1, "John Doe", "JohnDoe", "password", "USER");
        when(userService.updateUser(user)).thenReturn(null);

        // Act
        ResponseEntity<User> response = userController.updateUser(user.getUserId(), user);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(userService).updateUser(user);
    }

    @Test
    public void testDeleteUser_userExists_shouldReturnStatusNoContent() {
        // Arrange
        User user = new User(1, "John Doe", "JohnDoe", "password", "USER");
        when(userService.getUserById(1)).thenReturn(Optional.of(user));

        // Act
        ResponseEntity<Void> response = userController.deleteUser(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService).deleteUserById(1);
    }

    @Test
    public void testDeleteUser_userNotFound_shouldReturnStatusNotFound() {
        // Arrange
        when(userService.getUserById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Void> response = userController.deleteUser(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(userService, never()).deleteUserById(1);
    }

}
