package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.impl.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RatingService ratingService;

    @Test
    public void testGetRatings() {
        // Arrange
        Rating rating1 = new Rating();
        Rating rating2 = new Rating();
        List<Rating> expectedRatings = Arrays.asList(rating1, rating2);
        when(ratingRepository.findAll()).thenReturn(expectedRatings);

        // Act
        List<Rating> actualRatings = ratingService.getRatings();

        // Assert
        assertEquals(expectedRatings, actualRatings);
    }

    @Test
    public void testGetRatingById() {
        // Arrange
        Rating rating = new Rating();
        int ratingId = 1;
        when(ratingRepository.existsById(ratingId)).thenReturn(true);
        when(ratingRepository.findById(ratingId)).thenReturn(Optional.of(rating));

        // Act
        Optional<Rating> actualRating = ratingService.getRatingById(ratingId);

        // Assert
        assertTrue(actualRating.isPresent());
        assertEquals(rating, actualRating.get());
        verify(ratingRepository, times(1)).existsById(ratingId);
        verify(ratingRepository, times(1)).findById(ratingId);
    }

    @Test
    public void testAddRating() {
        // Arrange
        Rating rating = new Rating();
        when(ratingRepository.save(rating)).thenReturn(rating);

        // Act
        Rating actualRating = ratingService.addRating(rating);

        // Assert
        assertEquals(rating, actualRating);
    }

    @Test
    public void testDeleteRatingById() {
        // Arrange
        int ratingId = 1;
        when(ratingRepository.existsById(ratingId)).thenReturn(true);

        // Act
        ratingService.deleteRatingById(ratingId);

        // Assert
        verify(ratingRepository, Mockito.times(1)).deleteById(any());
    }
}