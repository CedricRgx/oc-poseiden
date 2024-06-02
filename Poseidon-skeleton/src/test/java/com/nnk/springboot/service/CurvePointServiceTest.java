package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.impl.CurvePointService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
        CurvePoint curvePoint = new CurvePoint();
        int curvePointId = 1;
        when(curvePointRepository.existsById(curvePointId)).thenReturn(true);
        when(curvePointRepository.findById(curvePointId)).thenReturn(Optional.of(curvePoint));

        // Act
        Optional<CurvePoint> actualCurvePoint = curvePointService.getCurvePointById(curvePointId);

        // Assert
        assertTrue(actualCurvePoint.isPresent());
        assertEquals(curvePoint, actualCurvePoint.get());
        verify(curvePointRepository, times(1)).existsById(curvePointId);
        verify(curvePointRepository, times(1)).findById(curvePointId);
    }

    @Test
    public void testAddCurvePoint() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointRepository.save(curvePoint)).thenReturn(curvePoint);

        // Act
        CurvePoint actualCurvePoint = curvePointService.addCurvePoint(curvePoint);

        // Assert
        assertEquals(curvePoint, actualCurvePoint);
    }

    @Test
    public void testUpdateCurvePoint() {
        // Arrange
        int existentCurvePointId = 1;
        int nonExistentCurvePointId = 2;
        CurvePoint existentCurvePoint = new CurvePoint();
        existentCurvePoint.setId(existentCurvePointId);
        existentCurvePoint.setTerm(54.32);
        CurvePoint nonExistentCurvePoint = new CurvePoint();
        nonExistentCurvePoint.setId(nonExistentCurvePointId);
        nonExistentCurvePoint.setTerm(54.32);

        // // Act
        when(curvePointRepository.existsById(existentCurvePointId)).thenReturn(true);
        when(curvePointRepository.existsById(nonExistentCurvePointId)).thenReturn(false);
        when(curvePointRepository.save(existentCurvePoint)).thenReturn(existentCurvePoint);

        // Arrange
        assertDoesNotThrow(() -> curvePointService.updateCurvePoint(existentCurvePoint));
        assertThrows(EntityNotFoundException.class, () -> curvePointService.updateCurvePoint(nonExistentCurvePoint));
    }

    @Test
    public void testDeleteCurvePointById() {
        // Arrange
        int curvePointId = 1;
        when(curvePointRepository.existsById(curvePointId)).thenReturn(true);

        // Act
        curvePointService.deleteCurvePointById(curvePointId);

        // Assert
        verify(curvePointRepository, Mockito.times(1)).deleteById(any());
    }

    @Test
    public void testVerifyBidListExistence() {
        // Arrange
        int existentCurvePointId = 1;
        int nonExistentCurvePointId = 2;

        // Act
        when(curvePointRepository.existsById(existentCurvePointId)).thenReturn(true);
        when(curvePointRepository.existsById(nonExistentCurvePointId)).thenReturn(false);

        // Assert
        assertDoesNotThrow(() -> curvePointService.verifyCurvePointExistence(existentCurvePointId));
        assertThrows(PoseidonEntityNotFoundException.class, () -> curvePointService.verifyCurvePointExistence(nonExistentCurvePointId));
    }
}