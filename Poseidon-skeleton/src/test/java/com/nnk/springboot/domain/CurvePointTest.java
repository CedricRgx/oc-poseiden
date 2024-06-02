package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class CurvePointTest {

    private CurvePoint curvePoint;
    private int curveId = 42;
    private Timestamp asOfDate = Timestamp.valueOf(LocalDate.of(2020, 05, 05).atStartOfDay());
    private Double term = 100.00;
    private Double value = 200.00;
    private Timestamp creationDate = Timestamp.valueOf(LocalDate.of(2022, 05, 05).atStartOfDay());

    @BeforeEach
    public void setUp() {
        curvePoint = new CurvePoint(curveId, asOfDate, term, value, creationDate);
    }

    @Test
    public void testCurvePointConstructor() {
        curvePoint = new CurvePoint();
        assertNotNull(curvePoint);
    }

    @Test
    public void testGetAsOfDate() {
        assertEquals(asOfDate, curvePoint.getAsOfDate());
    }

    @Test
    public void testSetAsOfDate() {
        curvePoint.setAsOfDate(asOfDate);
        assertEquals(asOfDate, curvePoint.getAsOfDate());
    }

    @Test
    public void testGetTerm() {
        assertEquals(term, curvePoint.getTerm());
    }

    @Test
    public void testSetTerm() {
        curvePoint.setTerm(term);
        assertEquals(term, curvePoint.getTerm());
    }

    @Test
    public void testGetValue() {
        assertEquals(value, curvePoint.getValue());
    }

    @Test
    public void testSetValue() {
        curvePoint.setValue(value);
        assertEquals(value, curvePoint.getValue());
    }

    @Test
    public void testGetCreationDate() {
        assertEquals(creationDate, curvePoint.getCreationDate());
    }

    @Test
    public void testSetCreationDate() {
        curvePoint.setCreationDate(creationDate);
        assertEquals(creationDate, curvePoint.getCreationDate());
    }

    @Test
    public void testBuilder() {
        // Arrange
        String expected = "CurvePoint(" +
                "id=null, " +
                "curveId=42, " +
                "asOfDate=2020-05-05 00:00:00.0, " +
                "term=100.0, " +
                "value=200.0, " +
                "creationDate=2022-05-05 00:00:00.0" +
                ")";

        // Act Assert
        assertEquals(expected, curvePoint.toString());
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        CurvePoint curvePointTest = new CurvePoint();

        // Act
        int initialHashCode = curvePointTest.hashCode();

        // Assert
        assertEquals(initialHashCode, curvePointTest.hashCode());
        assertEquals(initialHashCode, curvePointTest.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();

        // Act Assert
        assertEquals(curvePointTest1.hashCode(), curvePointTest2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Act
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();
        curvePointTest2.setTerm(42.42);

        // Act Assert
        assertNotEquals(curvePointTest1.hashCode(), curvePointTest2.hashCode());
    }

    @Test
    public void testHashCodeForNullFields() {
        // Act
        CurvePoint curvePointTest = new CurvePoint();
        curvePointTest.setTerm(null);

        // Act
        int hashCodeWithNull = curvePointTest.hashCode();
        curvePointTest.setTerm(42.42);
        int hashCodeWithoutNull = curvePointTest.hashCode();

        // Assert
        assertNotEquals(hashCodeWithNull, hashCodeWithoutNull);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        // Act
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();

        // Assert
        assertEquals(curvePointTest1.hashCode(), curvePointTest2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        // Act
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();
        curvePointTest2.setTerm(42.42);

        // Assert
        assertNotEquals(curvePointTest1.hashCode(), curvePointTest2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();
        curvePointTest1.setTerm(null);
        curvePointTest2.setTerm(null);

        // Assert
        assertEquals(curvePointTest1.hashCode(), curvePointTest2.hashCode());

        // Arrange
        curvePointTest1.setTerm(42.42);
        // Assert
        assertNotEquals(curvePointTest1.hashCode(), curvePointTest2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        // Arrange
        CurvePoint curvePointTest = new CurvePoint();

        // Assert
        assertEquals(curvePointTest, curvePointTest);
    }

    @Test
    public void testEqualsIdenticalObjects() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();

        // Assert
        assertEquals(curvePointTest1, curvePointTest2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();
        curvePointTest2.setTerm(42.42);

        // Assert
        assertNotEquals(curvePointTest1, curvePointTest2);
    }

    @Test
    public void testEqualsNullObject() {
        // Arrange
        CurvePoint curvePointTest = new CurvePoint();

        // Assert
        assertNotEquals(curvePointTest, null);
    }

    @Test
    public void testEqualsDifferentClassObject() {
        // Arrange
        CurvePoint curvePointTest = new CurvePoint();
        String differentClassObject = "String Test";

        // Assert
        assertNotEquals(curvePointTest, differentClassObject);
    }

    @Test
    public void testEqualsNullFields() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();
        curvePointTest1.setTerm(null);
        curvePointTest2.setTerm(null);

        // Assert
        assertEquals(curvePointTest1, curvePointTest2);

        // Arrange
        curvePointTest1.setTerm(42.42);
        // Assert
        assertNotEquals(curvePointTest1, curvePointTest2);
    }

    @Test
    public void testEqualsSymmetric() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();

        // Assert
        assertEquals(curvePointTest1, curvePointTest2);
        assertEquals(curvePointTest2, curvePointTest1);
    }

    @Test
    public void testEqualsTransitive() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();
        CurvePoint curvePointTest3 = new CurvePoint();

        // Assert
        assertEquals(curvePointTest1, curvePointTest2);
        assertEquals(curvePointTest2, curvePointTest3);
        assertEquals(curvePointTest1, curvePointTest3);
    }

    @Test
    public void testEqualsConsistent() {
        // Arrange
        CurvePoint curvePointTest1 = new CurvePoint();
        CurvePoint curvePointTest2 = new CurvePoint();

        // Assert
        assertEquals(curvePointTest1, curvePointTest2);
        assertEquals(curvePointTest1, curvePointTest2);
        assertEquals(curvePointTest1, curvePointTest2);
    }

}
