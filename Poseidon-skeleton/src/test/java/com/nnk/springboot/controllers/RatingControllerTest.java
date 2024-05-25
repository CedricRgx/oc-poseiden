/*
package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.impl.RatingService;
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
public class RatingControllerTest {

    @Mock
    private RatingService ratingService;

    @InjectMocks
    private RatingController ratingController;

    @Test
    public void testGetAllRatings_RatingExists_ShouldReturnFound() {
        // Arrange
        Rating ratingOne = new Rating();
        Rating ratingTwo = new Rating();
        List<Rating> ratings = Arrays.asList(ratingOne, ratingTwo);
        when(ratingService.getRatings()).thenReturn(ratings);

        // Act
        ResponseEntity<List<Rating>> response = ratingController.getAllRatings();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ratings, response.getBody());
    }

    @Test
    public void testGetAllRatings_NoRatingExists_ShouldReturnNotFound() {
        // Arrange
        when(ratingService.getRatings()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<Rating>> response = ratingController.getAllRatings();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void testGetRatingById_RatingExists_ShouldReturnFound() {
        // Arrange
        Rating rating = new Rating();
        when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));

        // Act
        ResponseEntity<Rating> response = ratingController.getRatingById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rating, response.getBody());
    }

    @Test
    public void getRatingById_RatingDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        Integer ratingId = 1;
        when(ratingService.getRatingById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Rating> response;
        response = ratingController.getRatingById(ratingId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testAddNewRating_ratingAddedSuccessfully_shouldReturnStatusCreated() {
        // Arrange
        Rating rating = new Rating();
        when(ratingService.addRating(rating)).thenReturn(rating);

        // Act
        ResponseEntity<Rating> response = ratingController.addNewRating(rating);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(rating, response.getBody());
    }

    @Test
    public void testAddNewRating_ratingAddedFailure_shouldReturnStatusBadRequest() {
        // Arrange
        Rating rating = new Rating();
        when(ratingService.addRating(rating)).thenReturn(null);

        // Act
        ResponseEntity<Rating> response = ratingController.addNewRating(rating);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateRating_ratingUpdatedSuccessfully_shouldReturnStatusOk() {
        // Arrange
        Rating rating = new Rating();
        when(ratingService.updateRating(rating)).thenReturn(rating);

        // Act
        ResponseEntity<Rating> response = ratingController.updateRating(rating.getId(), rating);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(rating, response.getBody());
        verify(ratingService).updateRating(rating);
    }

    @Test
    public void testUpdateRating_ratingUpdateFailure_shouldReturnStatusNotFound() {
        // Arrange
        Rating rating = new Rating();
        when(ratingService.updateRating(rating)).thenReturn(null);

        // Act
        ResponseEntity<Rating> response = ratingController.updateRating(rating.getId(), rating);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(ratingService).updateRating(rating);
    }

    @Test
    public void testDeleteRating_ratingExists_shouldReturnStatusNoContent() {
        // Arrange
        Rating rating = new Rating();
        when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));

        // Act
        ResponseEntity<Void> response = ratingController.deleteRating(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(ratingService).deleteRatingById(1);
    }

    @Test
    public void testDeleteRating_ratingNotFound_shouldReturnStatusNotFound() {
        // Arrange
        when(ratingService.getRatingById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Void> response = ratingController.deleteRating(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(ratingService, never()).deleteRatingById(1);
    }

}
*/
