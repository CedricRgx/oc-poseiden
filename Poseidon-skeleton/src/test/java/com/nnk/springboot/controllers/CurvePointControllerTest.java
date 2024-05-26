package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.impl.CurvePointService;
import com.nnk.springboot.service.impl.CurvePointService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CurvePointControllerTest {

    @InjectMocks
    private CurvePointController curvePointController;

    @Mock
    CurvePointService curvePointService;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void testHome() {
        // Arrange
        when(curvePointService.getCurvePoints()).thenReturn(new ArrayList<>());
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

        // Act
        String viewName = curvePointController.home(model);

        // Assert
        assertEquals("curvePoint/list", viewName);
    }

    @Test
    public void testAddBidForm() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();

        // Act
        String viewName = curvePointController.addCurveForm(curvePoint);

        // Assert
        assertEquals("curvePoint/add", viewName);
    }

    @Test
    public void testValidate() {
        // Arrange
        CurvePoint curvePoint = new CurvePoint();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = curvePointController.validate(curvePoint, bindingResult, model);

        // Assert
        assertEquals("redirect:/curvePoint/list", viewName);
    }

    @Test
    public void testShowUpdateForm() {
        // Arrange
        int id = 1;
        Optional<CurvePoint> curvePoint = Optional.of(new CurvePoint());
        when(curvePointService.getCurvePointById(id)).thenReturn(curvePoint);

        // Act
        String viewName = curvePointController.showUpdateForm(id, model);

        // Assert
        assertEquals("curvePoint/update", viewName);
    }

    @Test
    public void testUpdateBid() {
        // Arrange
        int id = 1;
        CurvePoint curvePoint = new CurvePoint();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = curvePointController.updateCurve(id, curvePoint, bindingResult, model);

        // Assert
        assertEquals("redirect:/curvePoint/list", viewName);
    }

    @Test
    public void testDeleteBid() {
        // Arrange
        int id = 1;

        // Act
        String viewName = curvePointController.deleteCurve(id, model);

        // Assert
        assertEquals("redirect:/curvePoint/list", viewName);
    }
    
}