package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testBuilder() {
        // Arrange
        String expected = "Rating(" +
                "id=null, " +
                "moodysRating=moodysRatingTest, " +
                "sandPRating=sandPRatingTest, " +
                "fitchRating=fitchRatingTest, " +
                "orderNumber=42" +
                ")";

        // Act Assert
        assertEquals(expected, rating.toString());
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        Rating ratingTest = new Rating();

        // Act
        int initialHashCode = ratingTest.hashCode();

        // Assert
        assertEquals(initialHashCode, ratingTest.hashCode());
        assertEquals(initialHashCode, ratingTest.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();

        // Act Assert
        assertEquals(ratingTest1.hashCode(), ratingTest2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Act
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();
        ratingTest2.setMoodysRating("DifferentAccount");

        // Act Assert
        assertNotEquals(ratingTest1.hashCode(), ratingTest2.hashCode());
    }

    @Test
    public void testHashCodeForNullFields() {
        // Act
        Rating ratingTest = new Rating();
        ratingTest.setMoodysRating(null);

        // Act
        int hashCodeWithNull = ratingTest.hashCode();
        ratingTest.setMoodysRating("NonNullMoodysRating");
        int hashCodeWithoutNull = ratingTest.hashCode();

        // Assert
        assertNotEquals(hashCodeWithNull, hashCodeWithoutNull);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        // Act
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();

        // Assert
        assertEquals(ratingTest1.hashCode(), ratingTest2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        // Act
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();
        ratingTest2.setMoodysRating("DifferentMoodysRating");

        // Assert
        assertNotEquals(ratingTest1.hashCode(), ratingTest2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();
        ratingTest1.setMoodysRating(null);
        ratingTest2.setMoodysRating(null);

        // Assert
        assertEquals(ratingTest1.hashCode(), ratingTest2.hashCode());

        // Arrange
        ratingTest1.setMoodysRating("NonNullMoodysRating");
        // Assert
        assertNotEquals(ratingTest1.hashCode(), ratingTest2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        // Arrange
        Rating ratingTest = new Rating();

        // Assert
        assertEquals(ratingTest, ratingTest);
    }

    @Test
    public void testEqualsIdenticalObjects() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();

        // Assert
        assertEquals(ratingTest1, ratingTest2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();
        ratingTest2.setMoodysRating("DifferentMoodysRating");

        // Assert
        assertNotEquals(ratingTest1, ratingTest2);
    }

    @Test
    public void testEqualsNullObject() {
        // Arrange
        Rating ratingTest = new Rating();

        // Assert
        assertNotEquals(ratingTest, null);
    }

    @Test
    public void testEqualsDifferentClassObject() {
        // Arrange
        Rating ratingTest = new Rating();
        String differentClassObject = "String Test";

        // Assert
        assertNotEquals(ratingTest, differentClassObject);
    }

    @Test
    public void testEqualsNullFields() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();
        ratingTest1.setMoodysRating(null);
        ratingTest2.setMoodysRating(null);

        // Assert
        assertEquals(ratingTest1, ratingTest2);

        // Arrange
        ratingTest1.setMoodysRating("NonNullMoodysRating");
        // Assert
        assertNotEquals(ratingTest1, ratingTest2);
    }

    @Test
    public void testEqualsSymmetric() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();

        // Assert
        assertEquals(ratingTest1, ratingTest2);
        assertEquals(ratingTest2, ratingTest1);
    }

    @Test
    public void testEqualsTransitive() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();
        Rating ratingTest3 = new Rating();

        // Assert
        assertEquals(ratingTest1, ratingTest2);
        assertEquals(ratingTest2, ratingTest3);
        assertEquals(ratingTest1, ratingTest3);
    }

    @Test
    public void testEqualsConsistent() {
        // Arrange
        Rating ratingTest1 = new Rating();
        Rating ratingTest2 = new Rating();

        // Assert
        assertEquals(ratingTest1, ratingTest2);
        assertEquals(ratingTest1, ratingTest2);
        assertEquals(ratingTest1, ratingTest2);
    }

}
