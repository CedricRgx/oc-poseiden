package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.impl.RuleNameService;
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
public class RuleNameControllerTest {

    @Mock
    private RuleNameService ruleNameService;

    @InjectMocks
    private RuleNameController ruleNameController;

    @Test
    public void testGetAllRuleNames_RuleNameExists_ShouldReturnFound() {
        // Arrange
        RuleName ruleNameOne = new RuleName();
        RuleName ruleNameTwo = new RuleName();
        List<RuleName> ruleNames = Arrays.asList(ruleNameOne, ruleNameTwo);
        when(ruleNameService.getRuleNames()).thenReturn(ruleNames);

        // Act
        ResponseEntity<List<RuleName>> response = ruleNameController.getAllRuleNames();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ruleNames, response.getBody());
    }

    @Test
    public void testGetAllRuleNames_NoRuleNameExists_ShouldReturnNotFound() {
        // Arrange
        when(ruleNameService.getRuleNames()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<RuleName>> response = ruleNameController.getAllRuleNames();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void testGetRuleNameById_RuleNameExists_ShouldReturnFound() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.of(ruleName));

        // Act
        ResponseEntity<RuleName> response = ruleNameController.getRuleNameById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ruleName, response.getBody());
    }

    @Test
    public void getRuleNameById_RuleNameDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        Integer ruleNameId = 1;
        when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<RuleName> response;
        response = ruleNameController.getRuleNameById(ruleNameId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testAddNewRuleName_ruleNameAddedSuccessfully_shouldReturnStatusCreated() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameService.addRuleName(ruleName)).thenReturn(ruleName);

        // Act
        ResponseEntity<RuleName> response = ruleNameController.addNewRuleName(ruleName);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ruleName, response.getBody());
    }

    @Test
    public void testAddNewRuleName_ruleNameAddedFailure_shouldReturnStatusBadRequest() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameService.addRuleName(ruleName)).thenReturn(null);

        // Act
        ResponseEntity<RuleName> response = ruleNameController.addNewRuleName(ruleName);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateRuleName_ruleNameUpdatedSuccessfully_shouldReturnStatusOk() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameService.updateRuleName(ruleName)).thenReturn(ruleName);

        // Act
        ResponseEntity<RuleName> response = ruleNameController.updateRuleName(ruleName.getRuleNameId(), ruleName);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ruleName, response.getBody());
        verify(ruleNameService).updateRuleName(ruleName);
    }

    @Test
    public void testUpdateRuleName_ruleNameUpdateFailure_shouldReturnStatusNotFound() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameService.updateRuleName(ruleName)).thenReturn(null);

        // Act
        ResponseEntity<RuleName> response = ruleNameController.updateRuleName(ruleName.getRuleNameId(), ruleName);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(ruleNameService).updateRuleName(ruleName);
    }

    @Test
    public void testDeleteRuleName_ruleNameExists_shouldReturnStatusNoContent() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.of(ruleName));

        // Act
        ResponseEntity<Void> response = ruleNameController.deleteRuleName(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(ruleNameService).deleteRuleNameById(1);
    }

    @Test
    public void testDeleteRuleName_ruleNameNotFound_shouldReturnStatusNotFound() {
        // Arrange
        when(ruleNameService.getRuleNameById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Void> response = ruleNameController.deleteRuleName(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(ruleNameService, never()).deleteRuleNameById(1);
    }

}
