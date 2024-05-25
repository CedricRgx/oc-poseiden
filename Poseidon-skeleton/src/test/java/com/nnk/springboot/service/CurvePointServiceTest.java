package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.impl.CurvePointService;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurvePointServiceTest {

    @Mock
    private CurvePointRepository curvePointRepository;

    @InjectMocks
    private CurvePointService curvePointService;

    @Test
    public void testGetCurvePoints() {
        // Arrange
        CurvePoint curvePoint1 = new CurvePoint();
        CurvePoint curvePoint2 = new CurvePoint();
        List<CurvePoint> expectedCurvePoints = Arrays.asList(curvePoint1, curvePoint2);
        when(curvePointRepository.findAll()).thenReturn(expectedCurvePoints);

        // Act
        List<CurvePoint> actualCurvePoints = curvePointService.getCurvePoints();

        // Assert
        assertEquals(expectedCurvePoints, actualCurvePoints);
    }

    @Test
    public void testGetCurvePointById() {
        // Arrange
        int curvePointId = 1;
        CurvePoint expectedCurvePoint = new CurvePoint();
        when(curvePointRepository.findById(curvePointId)).thenReturn(Optional.of(expectedCurvePoint));

        // Act
        Optional<CurvePoint> actualCurvePoint = curvePointService.getCurvePointById(curvePointId);

        // Assert
        assertEquals(expectedCurvePoint, actualCurvePoint.get());
    }

    @Test
    void testAddCurvePoint() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointRepository.save(curvePoint)).thenReturn(curvePoint);

        // Act
        CurvePoint actualCurvePoint = curvePointService.addCurvePoint(curvePoint);

        // Assert
        assertEquals(curvePoint, actualCurvePoint);
    }

    @Test
    void testDeleteCurvePointById() {
        // Arrange
        int curvePointId = 1;

        // Act
        curvePointService.deleteCurvePointById(curvePointId);

        // Assert
        verify(curvePointRepository, Mockito.times(1)).deleteById(curvePointId);
    }
}