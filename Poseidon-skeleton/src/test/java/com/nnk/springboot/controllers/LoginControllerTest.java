package com.nnk.springboot.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    Model model;

/*    @Test
    public void testLogin_withError_shouldAddErrorMessageToModel() {
        // Arrange
        String error = "error";

        // Act
        String viewName = loginController.login(model, error, null, null);

        // Assert
        verify(model).addAttribute("errorMessage", "Your username or password is incorrect.");
        assertEquals("login", viewName);
    }*/

    @Test
    public void testLogin_withLogout_shouldAddLogoutMessageToModel() {
        // Arrange
        String logout = "logout";

        // Act
        String viewName = loginController.login(model, null, logout);

        // Assert
        verify(model).addAttribute("logoutMessage", "You have been successfully logged out.");
        assertEquals("login", viewName);
    }

    @Test
    public void testLogin_withExpired_shouldAddLogoutMessageToModel() {
        // Arrange
        String expired = "expired";

        // Act
        String viewName = loginController.login(model, null, null);

        // Assert
        verify(model).addAttribute("expiredMessage", "Your session has been expired.");
        assertEquals("login", viewName);
    }

    @Test
    public void testLogin_withoutMessages_shouldReturnLoginView() {
        // Act
        String viewName = loginController.login(model, null, null);

        // Assert
        assertEquals("login", viewName);
    }



    @Test
    public void testError403_shouldReturnErrorView() {
        // Act
        String viewName = loginController.error(model);

        // Assert
        assertEquals("403", viewName);
    }

}
