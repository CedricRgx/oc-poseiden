package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.impl.RuleNameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RuleNameControllerTest {

    @InjectMocks
    private RuleNameController ruleNameController;

    @Mock
    RuleNameService ruleNameService;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void testHome() {
        // Arrange
        when(ruleNameService.getRuleNames()).thenReturn(new ArrayList<>());
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

        // Act
        String viewName = ruleNameController.home(model);

        // Assert
        assertEquals("ruleName/list", viewName);
    }

    @Test
    public void testAddRuleNameForm() {
        // Arrange
        RuleName ruleName = new RuleName();

        // Act
        String viewName = ruleNameController.addRuleNameForm(ruleName);

        // Assert
        assertEquals("ruleName/add", viewName);
    }

    @Test
    public void testValidate() {
        // Arrange
        RuleName ruleName = new RuleName();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = ruleNameController.validate(ruleName, bindingResult, model);

        // Assert
        assertEquals("redirect:/ruleName/list", viewName);
    }

    @Test
    public void testShowUpdateForm() {
        // Arrange
        int id = 1;
        Optional<RuleName> ruleName = Optional.of(new RuleName());
        when(ruleNameService.getRuleNameById(id)).thenReturn(ruleName);

        // Act
        String viewName = ruleNameController.showUpdateForm(id, model);

        // Assert
        assertEquals("ruleName/update", viewName);
    }

    @Test
    public void testUpdateRuleName() {
        // Arrange
        int id = 1;
        RuleName ruleName = new RuleName();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = ruleNameController.updateRuleName(id, ruleName, bindingResult, model);

        // Assert
        assertEquals("redirect:/ruleName/list", viewName);
    }

    @Test
    public void testDeleteRuleName() {
        // Arrange
        int id = 1;

        // Act
        String viewName = ruleNameController.deleteRuleName(id, model);

        // Assert
        assertEquals("redirect:/ruleName/list", viewName);
    }

}