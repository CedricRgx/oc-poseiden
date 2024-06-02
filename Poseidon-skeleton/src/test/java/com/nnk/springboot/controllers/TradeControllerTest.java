package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.impl.TradeService;
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
public class TradeControllerTest {

    @InjectMocks
    private TradeController tradeController;

    @Mock
    TradeService tradeService;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Test
    public void testHome() {
        // Arrange
        when(tradeService.getTrades()).thenReturn(new ArrayList<>());
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

        // Act
        String viewName = tradeController.home(model);

        // Assert
        assertEquals("trade/list", viewName);
    }

    @Test
    public void testHomeWhenGetTradesReturnsNull_thenVerifyLoggerError() {
        // Arrange
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
        when(tradeService.getTrades()).thenReturn(null);

        // Act
        String result = tradeController.home(model);

        // Assert
        assertEquals("trade/list", result);
    }

    @Test
    public void testAddTradeForm() {
        // Arrange
        Trade trade = new Trade();

        // Act
        String viewName = tradeController.addTradeForm(trade);

        // Assert
        assertEquals("trade/add", viewName);
    }

    @Test
    public void testValidate() {
        // Arrange
        Trade trade = new Trade();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = tradeController.validate(trade, bindingResult, model);

        // Assert
        assertEquals("redirect:/trade/list", viewName);
    }

    @Test
    public void testValidateWithErrors() {
        // Arrange
        Trade trade = new Trade();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = tradeController.validate(trade, bindingResult, model);

        // Assert
        assertEquals("trade/add", viewName);
    }

    @Test
    public void testShowUpdateForm() {
        // Arrange
        int id = 1;
        Optional<Trade> trade = Optional.of(new Trade());
        when(tradeService.getTradeById(id)).thenReturn(trade);

        // Act
        String viewName = tradeController.showUpdateForm(id, model);

        // Assert
        assertEquals("trade/update", viewName);
    }

    @Test
    public void testUpdateTrade() {
        // Arrange
        int id = 1;
        Trade trade = new Trade();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = tradeController.updateTrade(id, trade, bindingResult, model);

        // Assert
        assertEquals("redirect:/trade/list", viewName);
    }

    @Test
    public void testUpdateTradeWithInvalidId() {
        // Arrange
        Integer id = 999;
        when(tradeService.getTradeById(id)).thenReturn(Optional.empty());

        // Act
        String viewName = tradeController.showUpdateForm(id, model);

        // Assert
        assertEquals("trade/update", viewName);
    }

    @Test
    public void testUpdateTradeWithValidationError() {
        // Arrange
        Integer id = 1;
        Trade trade = new Trade();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = tradeController.updateTrade(id, trade, bindingResult, model);

        // Assert
        assertEquals("trade/update", viewName);
        verify(model).addAttribute("trade", trade);
    }

    @Test
    public void testDeleteTrade() {
        // Arrange
        int id = 1;

        // Act
        String viewName = tradeController.deleteTrade(id, model);

        // Assert
        assertEquals("redirect:/trade/list", viewName);
    }

}