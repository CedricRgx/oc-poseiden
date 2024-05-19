package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.impl.BidListService;
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

        // Act
        Optional<BidList> actualBidList = bidListService.getBidListById(bidListId);

        // Assert
        assertEquals(expectedBidList, actualBidList.get());
    }

    @Test
    void testAddBidList() {
        // Arrange
        BidList bidList = new BidList();
        when(bidListRepository.save(bidList)).thenReturn(bidList);

        // Act
        BidList actualBidList = bidListService.addBidList(bidList);

        // Assert
        assertEquals(bidList, actualBidList);
    }

    @Test
    void testDeleteBidListById() {
        // Arrange
        int bidListId = 1;

        // Act
        bidListService.deleteBidListById(bidListId);

        // Assert
        verify(bidListRepository, Mockito.times(1)).deleteById(bidListId);
    }
}
