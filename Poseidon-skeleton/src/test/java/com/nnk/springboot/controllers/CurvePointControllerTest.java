/*
package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.impl.CurvePointService;
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
public class CurvePointControllerTest {

    @Mock
    private CurvePointService curvePointService;

    @InjectMocks
    private CurvePointController curvePointController;

    @Test
    public void testGetAllCurvePoints_CurvePointExists_ShouldReturnFound() {
        // Arrange
        CurvePoint curvePointOne = new CurvePoint();
        CurvePoint curvePointTwo = new CurvePoint();
        List<CurvePoint> curvePoints = Arrays.asList(curvePointOne, curvePointTwo);
        when(curvePointService.getCurvePoints()).thenReturn(curvePoints);

        // Act
        ResponseEntity<List<CurvePoint>> response = curvePointController.getAllCurvePoints();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(curvePoints, response.getBody());
    }

    @Test
    public void testGetAllCurvePoints_NoCurvePointExists_ShouldReturnNotFound() {
        // Arrange
        when(curvePointService.getCurvePoints()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<CurvePoint>> response = curvePointController.getAllCurvePoints();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void testGetCurvePointById_CurvePointExists_ShouldReturnFound() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));

        // Act
        ResponseEntity<CurvePoint> response = curvePointController.getCurvePointById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(curvePoint, response.getBody());
    }

    @Test
    public void getCurvePointById_CurvePointDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        Integer curvePointId = 1;
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<CurvePoint> response;
        response = curvePointController.getCurvePointById(curvePointId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testAddNewCurvePoint_curvePointAddedSuccessfully_shouldReturnStatusCreated() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointService.addCurvePoint(curvePoint)).thenReturn(curvePoint);

        // Act
        ResponseEntity<CurvePoint> response = curvePointController.addNewCurvePoint(curvePoint);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(curvePoint, response.getBody());
    }

    @Test
    public void testAddNewCurvePoint_curvePointAddedFailure_shouldReturnStatusBadRequest() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointService.addCurvePoint(curvePoint)).thenReturn(null);

        // Act
        ResponseEntity<CurvePoint> response = curvePointController.addNewCurvePoint(curvePoint);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateCurvePoint_curvePointUpdatedSuccessfully_shouldReturnStatusOk() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointService.updateCurvePoint(curvePoint)).thenReturn(curvePoint);

        // Act
        ResponseEntity<CurvePoint> response = curvePointController.updateCurvePoint(curvePoint.getId(), curvePoint);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(curvePoint, response.getBody());
        verify(curvePointService).updateCurvePoint(curvePoint);
    }

    @Test
    public void testUpdateCurvePoint_curvePointUpdateFailure_shouldReturnStatusNotFound() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointService.updateCurvePoint(curvePoint)).thenReturn(null);

        // Act
        ResponseEntity<CurvePoint> response = curvePointController.updateCurvePoint(curvePoint.getId(), curvePoint);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(curvePointService).updateCurvePoint(curvePoint);
    }

    @Test
    public void testDeleteCurvePoint_curvePointExists_shouldReturnStatusNoContent() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));

        // Act
        ResponseEntity<Void> response = curvePointController.deleteCurvePoint(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(curvePointService).deleteCurvePointById(1);
    }

    @Test
    public void testDeleteCurvePoint_curvePointNotFound_shouldReturnStatusNotFound() {
        // Arrange
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Void> response = curvePointController.deleteCurvePoint(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(curvePointService, never()).deleteCurvePointById(1);
    }

}
*/
