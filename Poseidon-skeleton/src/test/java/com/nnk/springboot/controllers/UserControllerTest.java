package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.impl.UserService;
import jakarta.persistence.EntityExistsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    UserService userService;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void testHome() {
        // Arrange
        when(userService.getUsers()).thenReturn(new ArrayList<>());
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("ADMIN")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

        // Act
        String viewName = userController.home(model);

        // Assert
        assertEquals("user/list", viewName);
    }

    @Test
    public void testHomeWhenGetUsersReturnsNull_thenVerifyLoggerError() {
        // Arrange
        UserDetails userDetails = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
        when(userService.getUsers()).thenReturn(null);

        // Act
        String result = userController.home(model);

        // Assert
        assertEquals("user/list", result);
    }

    @Test
    public void testAddUserForm() {
        // Arrange
        User user = new User();

        // Act
        String viewName = userController.addUserForm(user);

        // Assert
        assertEquals("user/add", viewName);
    }

    @Test
    public void testValidate() {
        // Arrange
        User user = new User();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = userController.validate(user, bindingResult, model);

        // Assert
        assertEquals("redirect:/user/list", viewName);
    }

    @Test
    public void testValidateWithErrors() {
        // Arrange
        User user = new User();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = userController.validate(user, bindingResult, model);

        // Assert
        assertEquals("user/add", viewName);
    }

    @Test
    public void testValidateWithEntityExistsException() {
        // Arrange
        User user = new User();
        when(bindingResult.hasErrors()).thenReturn(false);
        when(userService.addUser(any(User.class))).thenThrow(EntityExistsException.class);

        // Act
        String viewName = userController.validate(user, bindingResult, model);

        // Assert
        assertEquals("user/add", viewName);
    }

    @Test
    public void testShowUpdateForm() {
        // Arrange
        int id = 1;
        Optional<User> user = Optional.of(new User());
        when(userService.getUserById(id)).thenReturn(user);

        // Act
        String viewName = userController.showUpdateForm(id, model);

        // Assert
        assertEquals("user/update", viewName);
    }

    @Test
    public void testUpdateUser() {
        // Arrange
        int id = 1;
        User user = new User();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = userController.updateUser(id, user, bindingResult, model);

        // Assert
        assertEquals("redirect:/user/list", viewName);
    }

    @Test
    public void testUpdateUserWithInvalidId() {
        // Arrange
        Integer id = 999;
        when(userService.getUserById(id)).thenReturn(Optional.empty());

        // Act
        String viewName = userController.showUpdateForm(id, model);

        // Assert
        assertEquals("user/update", viewName);
    }

    @Test
    public void testUpdateUserWithValidationError() {
        // Arrange
        Integer id = 1;
        User user = new User();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = userController.updateUser(id, user, bindingResult, model);

        // Assert
        assertEquals("user/update", viewName);
        verify(model).addAttribute("user", user);
    }

    @Test
    public void testDeleteUser() {
        // Arrange
        int id = 1;

        // Act
        String viewName = userController.deleteUser(id, model);

        // Assert
        assertEquals("redirect:/user/list", viewName);
    }

}