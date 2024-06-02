package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.impl.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RatingControllerTest {

    @InjectMocks
    private RatingController ratingController;

    @Mock
    RatingService ratingService;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void testHome() {
        // Arrange
        when(ratingService.getRatings()).thenReturn(new ArrayList<>());
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

        // Act
        String viewName = ratingController.home(model);

        // Assert
        assertEquals("rating/list", viewName);
    }

    @Test
    public void testHomeWhenGetRatingsReturnsNull_thenVerifyLoggerError() {
        // Arrange
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
        when(ratingService.getRatings()).thenReturn(null);

        // Act
        String result = ratingController.home(model);

        // Assert
        assertEquals("rating/list", result);
    }

    @Test
    public void testAddRatingForm() {
        // Arrange
        Rating rating = new Rating();

        // Act
        String viewName = ratingController.addRatingForm(rating);

        // Assert
        assertEquals("rating/add", viewName);
    }

    @Test
    public void testValidate() {
        // Arrange
        Rating rating = new Rating();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = ratingController.validate(rating, bindingResult, model);

        // Assert
        assertEquals("redirect:/rating/list", viewName);
    }

    @Test
    public void testValidateWithErrors() {
        // Arrange
        Rating rating = new Rating();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = ratingController.validate(rating, bindingResult, model);

        // Assert
        assertEquals("rating/add", viewName);
    }

    @Test
    public void testShowUpdateForm() {
        // Arrange
        int id = 1;
        Optional<Rating> rating = Optional.of(new Rating());
        when(ratingService.getRatingById(id)).thenReturn(rating);

        // Act
        String viewName = ratingController.showUpdateForm(id, model);

        // Assert
        assertEquals("rating/update", viewName);
    }

    @Test
    public void testUpdateRating() {
        // Arrange
        int id = 1;
        Rating rating = new Rating();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = ratingController.updateRating(id, rating, bindingResult, model);

        // Assert
        assertEquals("redirect:/rating/list", viewName);
    }

    @Test
    public void testUpdateRatingWithInvalidId() {
        // Arrange
        Integer id = 999;
        when(ratingService.getRatingById(id)).thenReturn(Optional.empty());

        // Act
        String viewName = ratingController.showUpdateForm(id, model);

        // Assert
        assertEquals("rating/update", viewName);
    }

    @Test
    public void testUpdateRatingWithValidationError() {
        // Arrange
        Integer id = 1;
        Rating rating = new Rating();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = ratingController.updateRating(id, rating, bindingResult, model);

        // Assert
        assertEquals("rating/update", viewName);
        verify(model).addAttribute("rating", rating);
    }

    @Test
    public void testDeleteRating() {
        // Arrange
        int id = 1;

        // Act
        String viewName = ratingController.deleteRating(id, model);

        // Assert
        assertEquals("redirect:/rating/list", viewName);
    }

}