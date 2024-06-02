package com.nnk.springboot.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private Model model;

    @Test
    public void testHome() {
        // Arrange
        String viewName = homeController.home(model);

        // Assert
        assertEquals("home", viewName);
    }

    @Test
    public void testAdminHome() {
        // Arrange
        String viewName = homeController.adminHome(model);

        // Assert
        assertEquals("redirect:/user/list", viewName);
    }

}
