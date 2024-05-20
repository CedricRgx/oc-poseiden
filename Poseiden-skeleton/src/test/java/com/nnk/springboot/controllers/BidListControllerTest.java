package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.impl.BidListService;
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
public class BidListControllerTest {

    @Mock
    private BidListService bidListService;

    @InjectMocks
    private BidListController bidListController;

    @Test
    public void testGetAllBidLists_BidListExists_ShouldReturnFound() {
        // Arrange
        BidList bidListOne = new BidList();
        BidList bidListTwo = new BidList();
        List<BidList> bidLists = Arrays.asList(bidListOne, bidListTwo);
        when(bidListService.getBidLists()).thenReturn(bidLists);

        // Act
        ResponseEntity<List<BidList>> response = bidListController.getAllBidLists();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bidLists, response.getBody());
    }

    @Test
    public void testGetAllBidLists_NoBidListExists_ShouldReturnNotFound() {
        // Arrange
        when(bidListService.getBidLists()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<BidList>> response = bidListController.getAllBidLists();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }

    @Test
    public void testGetBidListById_BidListExists_ShouldReturnFound() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListService.getBidListById(1)).thenReturn(Optional.of(bidList));

        // Act
        ResponseEntity<BidList> response = bidListController.getBidListById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bidList, response.getBody());
    }

    @Test
    public void getBidListById_BidListDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        Integer bidListId = 1;
        when(bidListService.getBidListById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<BidList> response;
        response = bidListController.getBidListById(bidListId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testAddNewBidList_bidListAddedSuccessfully_shouldReturnStatusCreated() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListService.addBidList(bidList)).thenReturn(bidList);

        // Act
        ResponseEntity<BidList> response = bidListController.addNewBidList(bidList);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(bidList, response.getBody());
    }

    @Test
    public void testAddNewBidList_bidListAddedFailure_shouldReturnStatusBadRequest() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListService.addBidList(bidList)).thenReturn(null);

        // Act
        ResponseEntity<BidList> response = bidListController.addNewBidList(bidList);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateBidList_bidListUpdatedSuccessfully_shouldReturnStatusOk() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListService.updateBidList(bidList)).thenReturn(bidList);

        // Act
        ResponseEntity<BidList> response = bidListController.updateBidList(bidList.getBidListId(), bidList);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(bidList, response.getBody());
        verify(bidListService).updateBidList(bidList);
    }

    @Test
    public void testUpdateBidList_bidListUpdateFailure_shouldReturnStatusNotFound() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListService.updateBidList(bidList)).thenReturn(null);

        // Act
        ResponseEntity<BidList> response = bidListController.updateBidList(bidList.getBidListId(), bidList);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(bidListService).updateBidList(bidList);
    }

    @Test
    public void testDeleteBidList_bidListExists_shouldReturnStatusNoContent() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListService.getBidListById(1)).thenReturn(Optional.of(bidList));

        // Act
        ResponseEntity<Void> response = bidListController.deleteBidList(1);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(bidListService).deleteBidListById(1);
    }

    @Test
    public void testDeleteBidList_bidListNotFound_shouldReturnStatusNotFound() {
        // Arrange
        when(bidListService.getBidListById(1)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Void> response = bidListController.deleteBidList(1);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(bidListService, never()).deleteBidListById(1);
    }

}
