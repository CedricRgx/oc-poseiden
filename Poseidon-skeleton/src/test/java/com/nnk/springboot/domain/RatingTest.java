package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class RatingTest {

    private Rating rating;
    private String moodysRating = "moodysRatingTest";
    private String sandPRating = "sandPRatingTest";
    private String fitchRating = "fitchRatingTest";
    private Integer orderNumber = 42;

    @BeforeEach
    public void setUp() {
        rating = new Rating(moodysRating, sandPRating, fitchRating, orderNumber);
    }

    @Test
    public void testRatingConstructor() {
        rating = new Rating();
        assertNotNull(rating);
    }

    @Test
    public void testGetMoodysRating() {
        assertEquals(moodysRating, rating.getMoodysRating());
    }

    @Test
    public void testSetMoodysRating() {
        rating.setMoodysRating(moodysRating);
        assertEquals(moodysRating, rating.getMoodysRating());
    }

    @Test
    public void testGetSandPRating() {
        assertEquals(sandPRating, rating.getSandPRating());
    }

    @Test
    public void testSetSandPRating() {
        rating.setSandPRating(sandPRating);
        assertEquals(sandPRating, rating.getSandPRating());
    }

    @Test
    public void testGetFitchRating() {
        assertEquals(fitchRating, rating.getFitchRating());
    }

    @Test
    public void testSetFitchRating() {
        rating.setFitchRating(fitchRating);
        assertEquals(fitchRating, rating.getFitchRating());
    }

    @Test
    public void testGetOrderNumber() {
        assertEquals(orderNumber, rating.getOrderNumber());
    }

    @Test
    public void testSetOrderNumber() {
        rating.setOrderNumber(orderNumber);
        assertEquals(orderNumber, rating.getOrderNumber());
    }

}
