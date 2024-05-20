package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.impl.TradeService;
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
public class TradeControllerTest {

    @Mock
    private TradeService tradeService;

    @InjectMocks
    private TradeController tradeController;

    @Test
    public void testGetAllTrades_TradeExists_ShouldReturnFound() {
        // Arrange
        Trade tradeOne = new Trade();
        Trade tradeTwo = new Trade();
        List<Trade> trades = Arrays.asList(tradeOne, tradeTwo);
        when(tradeService.getTrades()).thenReturn(trades);

        // Act
        ResponseEntity<List<Trade>> response = tradeController.getAllTrades();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trades, response.getBody());
    }

    @Test
    public void testGetAllTrades_NoTradeExists_ShouldReturnNotFound() {
        // Arrange
        when(tradeService.getTrades()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<Trade>> response = tradeController.getAllTrades();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void testGetTradeById_TradeExists_ShouldReturnFound() {
        // Arrange
        Trade trade = new Trade();
        when(tradeService.getTradeById(1)).thenReturn(Optional.of(trade));

        // Act
        ResponseEntity<Trade> response = tradeController.getTradeById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trade, response.getBody());
    }

    @Test
    public void getTradeById_TradeDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        Integer tradeId = 1;
        when(tradeService.getTradeById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Trade> response;
        response = tradeController.getTradeById(tradeId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testAddNewTrade_tradeAddedSuccessfully_shouldReturnStatusCreated() {
        // Arrange
        Trade trade = new Trade();
        when(tradeService.addTrade(trade)).thenReturn(trade);

        // Act
        ResponseEntity<Trade> response = tradeController.addNewTrade(trade);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(trade, response.getBody());
    }

    @Test
    public void testAddNewTrade_tradeAddedFailure_shouldReturnStatusBadRequest() {
        // Arrange
        Trade trade = new Trade();
        when(tradeService.addTrade(trade)).thenReturn(null);

        // Act
        ResponseEntity<Trade> response = tradeController.addNewTrade(trade);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateTrade_tradeUpdatedSuccessfully_shouldReturnStatusOk() {
        // Arrange
        Trade trade = new Trade();
        when(tradeService.updateTrade(trade)).thenReturn(trade);

        // Act
        ResponseEntity<Trade> response = tradeController.updateTrade(trade.getTradeId(), trade);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(trade, response.getBody());
        verify(tradeService).updateTrade(trade);
    }

    @Test
    public void testUpdateTrade_tradeUpdateFailure_shouldReturnStatusNotFound() {
        // Arrange
        Trade trade = new Trade();
        when(tradeService.updateTrade(trade)).thenReturn(null);

        // Act
        ResponseEntity<Trade> response = tradeController.updateTrade(trade.getTradeId(), trade);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(tradeService).updateTrade(trade);
    }

    @Test
    public void testDeleteTrade_tradeExists_shouldReturnStatusNoContent() {
        // Arrange
        Trade trade = new Trade();
        when(tradeService.getTradeById(1)).thenReturn(Optional.of(trade));

        // Act
        ResponseEntity<Void> response = tradeController.deleteTrade(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(tradeService).deleteTradeById(1);
    }

    @Test
    public void testDeleteTrade_tradeNotFound_shouldReturnStatusNotFound() {
        // Arrange
        when(tradeService.getTradeById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Void> response = tradeController.deleteTrade(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(tradeService, never()).deleteTradeById(1);
    }

}
