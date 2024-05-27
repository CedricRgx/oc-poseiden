package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.impl.RuleNameService;
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

@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest {

    @Mock
    private RuleNameRepository ruleNameRepository;

    @InjectMocks
    private RuleNameService ruleNameService;

    @Test
    public void testGetRuleNames() {
        // Arrange
        RuleName ruleName1 = new RuleName();
        RuleName ruleName2 = new RuleName();
        List<RuleName> expectedRuleNames = Arrays.asList(ruleName1, ruleName2);
        when(ruleNameRepository.findAll()).thenReturn(expectedRuleNames);

        // Act
        List<RuleName> actualRuleNames = ruleNameService.getRuleNames();

        // Assert
        assertEquals(expectedRuleNames, actualRuleNames);
    }

    @Test
    public void testGetRuleNameById() {
        // Arrange
        RuleName ruleName = new RuleName();
        int ruleNameId = 1;
        when(ruleNameRepository.existsById(ruleNameId)).thenReturn(true);
        when(ruleNameRepository.findById(ruleNameId)).thenReturn(Optional.of(ruleName));

        // Act
        Optional<RuleName> actualRuleName = ruleNameService.getRuleNameById(ruleNameId);

        // Assert
        assertTrue(actualRuleName.isPresent());
        assertEquals(ruleName, actualRuleName.get());
        verify(ruleNameRepository, times(1)).existsById(ruleNameId);
        verify(ruleNameRepository, times(1)).findById(ruleNameId);
    }

    @Test
    void testAddRuleName() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(ruleNameRepository.save(ruleName)).thenReturn(ruleName);

        // Act
        RuleName actualRuleName = ruleNameService.addRuleName(ruleName);

        // Assert
        assertEquals(ruleName, actualRuleName);
    }

    @Test
    public void testDeleteRuleNameById() {
        // Arrange
        int ruleNameId = 1;
        when(ruleNameRepository.existsById(ruleNameId)).thenReturn(true);

        // Act
        ruleNameService.deleteRuleNameById(ruleNameId);

        // Assert
        verify(ruleNameRepository, Mockito.times(1)).deleteById(any());
    }
}