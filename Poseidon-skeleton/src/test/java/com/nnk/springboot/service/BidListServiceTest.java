package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.impl.BidListService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BidListServiceTest {

    @Mock
    private BidListRepository bidListRepository;

    @InjectMocks
    private BidListService bidListService;

    @Test
    public void testGetBidLists() {
        // Arrange
        BidList bidList1 = new BidList();
        BidList bidList2 = new BidList();
        List<BidList> expectedBidLists = Arrays.asList(bidList1, bidList2);
        when(bidListRepository.findAll()).thenReturn(expectedBidLists);

        // Act
        List<BidList> actualBidLists = bidListService.getBidLists();

        // Assert
        assertEquals(expectedBidLists, actualBidLists);
    }

    @Test
    public void testGetBidListById() {
        // Arrange
        int bidListId = 1;
        BidList expectedBidList = new BidList();
        when(bidListRepository.findById(bidListId)).thenReturn(Optional.of(expectedBidList));
        when(bidListRepository.existsById(bidListId)).thenReturn(true);

        // Act
        Optional<BidList> actualBidList = bidListService.getBidListById(bidListId);

        // Assert
        assertEquals(expectedBidList, actualBidList.get());
    }

    @Test
    public void testAddBidList() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListRepository.save(bidList)).thenReturn(bidList);

        // Act
        BidList actualBidList = bidListService.addBidList(bidList);

        // Assert
        assertEquals(bidList, actualBidList);
    }

    @Test
    public void testUpdateBidList() {
        // Arrange
        int existentBidListId = 1;
        int nonExistentBidListId = 2;
        BidList existentBidList = new BidList();
        existentBidList.setId(existentBidListId);
        existentBidList.setBenchmark("ExistBenchmark");
        BidList nonExistentBidList = new BidList();
        nonExistentBidList.setId(nonExistentBidListId);
        nonExistentBidList.setBenchmark("NonExistBidList");

        // // Act
        when(bidListRepository.existsById(existentBidListId)).thenReturn(true);
        when(bidListRepository.existsById(nonExistentBidListId)).thenReturn(false);
        when(bidListRepository.save(existentBidList)).thenReturn(existentBidList);

        // Arrange
        assertDoesNotThrow(() -> bidListService.updateBidList(existentBidList));
        assertThrows(EntityNotFoundException.class, () -> bidListService.updateBidList(nonExistentBidList));
    }

    @Test
    public void testDeleteBidListById() {
        // Arrange
        int bidListId = 1;
        when(bidListRepository.existsById(bidListId)).thenReturn(true);

        // Act
        bidListService.deleteBidListById(bidListId);

        // Assert
        verify(bidListRepository, Mockito.times(1)).deleteById(any());
    }

    @Test
    public void testVerifyBidListExistence() {
        // Arrange
        int existentBidListId = 1;
        int nonExistentBidListId = 2;

        // Act
        when(bidListRepository.existsById(existentBidListId)).thenReturn(true);
        when(bidListRepository.existsById(nonExistentBidListId)).thenReturn(false);

        // Assert
        assertDoesNotThrow(() -> bidListService.verifyBidListExistence(existentBidListId));
        assertThrows(PoseidonEntityNotFoundException.class, () -> bidListService.verifyBidListExistence(nonExistentBidListId));
    }
}
