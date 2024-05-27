package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
