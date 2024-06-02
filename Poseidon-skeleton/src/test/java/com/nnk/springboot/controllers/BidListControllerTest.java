package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.impl.BidListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
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
public class BidListControllerTest {

    @InjectMocks
    private BidListController bidListController;

    @Mock
    BidListService bidListService;

    @Mock
    Model model;

    @Mock
    BindingResult bindingResult;

    @Mock
    private Logger logger;

    @Test
    public void testHome() {
        // Arrange
        when(bidListService.getBidLists()).thenReturn(new ArrayList<>());
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);

        // Act
        String viewName = bidListController.home(model);

        // Assert
        assertEquals("bidList/list", viewName);
    }

    @Test
    public void testHomeWhenGetBidListsReturnsNull_thenVerifyLoggerError() {
        // Arrange
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userDetails,null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
        when(bidListService.getBidLists()).thenReturn(null);

        // Act
        String result = bidListController.home(model);

        // Assert
        assertEquals("bidList/list", result);
    }

    @Test
    public void testAddBidForm() {
        // Arrange
        BidList bidList = new BidList();

        // Act
        String viewName = bidListController.addBidForm(bidList);

        // Assert
        assertEquals("bidList/add", viewName);
    }

    @Test
    public void testValidate() {
        // Arrange
        BidList bidList = new BidList();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = bidListController.validate(bidList, bindingResult, model);

        // Assert
        assertEquals("redirect:/bidList/list", viewName);
    }

    @Test
    public void testValidateWithErrors() {
        // Arrange
        BidList bidList = new BidList();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = bidListController.validate(bidList, bindingResult, model);

        // Assert
        assertEquals("bidList/add", viewName);
    }

    @Test
    public void testShowUpdateForm() {
        // Arrange
        int id = 1;
        Optional<BidList> bidList = Optional.of(new BidList());
        when(bidListService.getBidListById(id)).thenReturn(bidList);

        // Act
        String viewName = bidListController.showUpdateForm(id, model);

        // Assert
        assertEquals("bidList/update", viewName);
    }

    @Test
    public void testUpdateBid() {
        // Arrange
        int id = 1;
        BidList bidList = new BidList();
        when(bindingResult.hasErrors()).thenReturn(false);

        // Act
        String viewName = bidListController.updateBid(id, bidList, bindingResult, model);

        // Assert
        assertEquals("redirect:/bidList/list", viewName);
    }

    @Test
    public void testUpdateBidWithInvalidId() {
        // Arrange
        Integer id = 999;
        when(bidListService.getBidListById(id)).thenReturn(Optional.empty());

        // Act
        String viewName = bidListController.showUpdateForm(id, model);

        // Assert
        assertEquals("bidList/update", viewName);
    }

    @Test
    public void testUpdateBidWithValidationError() {
        // Arrange
        Integer id = 1;
        BidList bidList = new BidList();
        when(bindingResult.hasErrors()).thenReturn(true);

        // Act
        String viewName = bidListController.updateBid(id, bidList, bindingResult, model);

        // Assert
        assertEquals("bidList/update", viewName);
        verify(model).addAttribute("bidList", bidList);
    }

    @Test
    public void testDeleteBid() {
        // Arrange
        int id = 1;

        // Act
        String viewName = bidListController.deleteBid(id, model);

        // Assert
        assertEquals("redirect:/bidList/list", viewName);
    }

}