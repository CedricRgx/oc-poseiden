package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.impl.TradeService;
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
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {

    @Mock
    private TradeRepository tradeRepository;

    @InjectMocks
    private TradeService tradeService;

    @Test
    public void testGetTrades() {
        // Arrange
        Trade trade1 = new Trade();
        Trade trade2 = new Trade();
        List<Trade> expectedTrades = Arrays.asList(trade1, trade2);
        when(tradeRepository.findAll()).thenReturn(expectedTrades);

        // Act
        List<Trade> actualTrades = tradeService.getTrades();

        // Assert
        assertEquals(expectedTrades, actualTrades);
    }

    @Test
    public void testGetTradeById() {
        // Arrange
        Trade trade = new Trade();
        int tradeId = 1;
        when(tradeRepository.existsById(tradeId)).thenReturn(true);
        when(tradeRepository.findById(tradeId)).thenReturn(Optional.of(trade));

        // Act
        Optional<Trade> actualTrade = tradeService.getTradeById(tradeId);

        // Assert
        assertTrue(actualTrade.isPresent());
        assertEquals(trade, actualTrade.get());
        verify(tradeRepository, times(1)).existsById(tradeId);
        verify(tradeRepository, times(1)).findById(tradeId);
    }

    @Test
    void testAddTrade() {
        // Arrange
        Trade trade = new Trade();
        when(tradeRepository.save(trade)).thenReturn(trade);

        // Act
        Trade actualTrade = tradeService.addTrade(trade);

        // Assert
        assertEquals(trade, actualTrade);
    }

    @Test
    public void testDeleteTradeById() {
        // Arrange
        int tradeId = 1;
        when(tradeRepository.existsById(tradeId)).thenReturn(true);

        // Act
        tradeService.deleteTradeById(tradeId);

        // Assert
        verify(tradeRepository, Mockito.times(1)).deleteById(any());
    }
}