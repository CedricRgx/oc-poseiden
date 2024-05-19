package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BidListTest {

    private BidList bidList;
    private String account = "AccountTest";
    private String type = "TypeTest";
    private double bidQuantity = 100.00;
    private double askQuantity = 200.00;
    private double bid = 150.00;
    private double ask = 175.00;
    private String benchmark = "BenchmarkTest";
    private Timestamp bidListDate = Timestamp.valueOf(LocalDate.of(2020, 05, 05).atStartOfDay());
    private String commentary = "CommentaryTest";
    private String security = "SecurityTest";
    private String status = "StatusTest";
    private String trader = "TraderTest";
    private String book = "BookTest";
    private String creationName = "CreationNameTest";
    private Timestamp creationDate = Timestamp.valueOf(LocalDate.of(2022, 05, 05).atStartOfDay());
    private String revisionName = "RevisionNameTest";
    private Timestamp revisionDate = Timestamp.valueOf(LocalDate.of(2021, 05, 05).atStartOfDay());
    private String dealName = "DealNameTest";
    private String dealType = "DealTypeTest";
    private String sourceListId = "SourceListIdTest";
    private String side = "SideTest";

    @BeforeEach
    public void setUp() {
        bidList = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);
    }

    @Test
    public void testBidListConstructor() {
        bidList = new BidList();
        assertNotNull(bidList);
    }

    @Test
    public void testGetAccount() {
        assertEquals(account, bidList.getAccount());
    }

    @Test
    public void testSetAccount() {
        bidList.setAccount(account);
        assertEquals(account, bidList.getAccount());
    }

    @Test
    public void testGetType() {
        assertEquals(type, bidList.getType());
    }

    @Test
    public void testSetType() {
        bidList.setType(type);
        assertEquals(type, bidList.getType());
    }

    @Test
    public void testGetBidQuantity() {
        assertEquals(bidQuantity, bidList.getBidQuantity());
    }

    @Test
    public void testSetBidQuantity() {
        bidList.setBidQuantity(bidQuantity);
        assertEquals(bidQuantity, bidList.getBidQuantity());
    }

    @Test
    public void testGetAskQuantity() {
        assertEquals(askQuantity, bidList.getAskQuantity());
    }

    @Test
    public void testSetAskQuantity() {
        bidList.setAskQuantity(askQuantity);
        assertEquals(askQuantity, bidList.getAskQuantity());
    }

    @Test
    public void testGetBid() {
        assertEquals(bid, bidList.getBid());
    }

    @Test
    public void testSetBid() {
        bidList.setBid(bid);
        assertEquals(bid, bidList.getBid());
    }

    @Test
    public void testGetAsk() {
        assertEquals(ask, bidList.getAsk());
    }

    @Test
    public void testSetAsk() {
        bidList.setAsk(ask);
        assertEquals(ask, bidList.getAsk());
    }

    @Test
    public void testGetBenchmark() {
        assertEquals(benchmark, bidList.getBenchmark());
    }

    @Test
    public void testSetBenchmark() {
        bidList.setBenchmark(benchmark);
        assertEquals(benchmark, bidList.getBenchmark());
    }

    @Test
    public void testGetBidListDate() {
        assertEquals(bidListDate, bidList.getBidListDate());
    }

    @Test
    public void testSetBidListDate() {
        bidList.setBidListDate(bidListDate);
        assertEquals(bidListDate, bidList.getBidListDate());
    }

    @Test
    public void testGetCommentary() {
        assertEquals(commentary, bidList.getCommentary());
    }

    @Test
    public void testSetCommentary() {
        bidList.setCommentary(commentary);
        assertEquals(commentary, bidList.getCommentary());
    }

    @Test
    public void testGetSecurity() {
        assertEquals(security, bidList.getSecurity());
    }

    @Test
    public void testSetSecurity() {
        bidList.setSecurity(security);
        assertEquals(security, bidList.getSecurity());
    }

    @Test
    public void testGetStatus() {
        assertEquals(status, bidList.getStatus());
    }

    @Test
    public void testSetStatus() {
        bidList.setStatus(status);
        assertEquals(status, bidList.getStatus());
    }

    @Test
    public void testGetTrader() {
        assertEquals(trader, bidList.getTrader());
    }

    @Test
    public void testSetTrader() {
        bidList.setTrader(trader);
        assertEquals(trader, bidList.getTrader());
    }

    @Test
    public void testGetBook() {
        assertEquals(book, bidList.getBook());
    }

    @Test
    public void testSetBook() {
        bidList.setBook(book);
        assertEquals(book, bidList.getBook());
    }

    @Test
    public void testGetCreationName() {
        assertEquals(creationName, bidList.getCreationName());
    }

    @Test
    public void testSetCreationName() {
        bidList.setCreationName(creationName);
        assertEquals(creationName, bidList.getCreationName());
    }

    @Test
    public void testGetCreationDate() {
        assertEquals(creationDate, bidList.getCreationDate());
    }

    @Test
    public void testSetCreationDate() {
        bidList.setCreationDate(creationDate);
        assertEquals(creationDate, bidList.getCreationDate());
    }

    @Test
    public void testGetRevisionName() {
        assertEquals(revisionName, bidList.getRevisionName());
    }

    @Test
    public void testSetRevisionName() {
        bidList.setRevisionName(revisionName);
        assertEquals(revisionName, bidList.getRevisionName());
    }

    @Test
    public void testGetRevisionDate() {
        assertEquals(revisionDate, bidList.getRevisionDate());
    }

    @Test
    public void testSetRevisionDate() {
        bidList.setRevisionDate(revisionDate);
        assertEquals(revisionDate, bidList.getRevisionDate());
    }

    @Test
    public void testGetDealName() {
        assertEquals(dealName, bidList.getDealName());
    }

    @Test
    public void testSetDealName() {
        bidList.setDealName(dealName);
        assertEquals(dealName, bidList.getDealName());
    }

    @Test
    public void testGetDealType() {
        assertEquals(dealType, bidList.getDealType());
    }

    @Test
    public void testSetDealType() {
        bidList.setDealType(dealType);
        assertEquals(dealType, bidList.getDealType());
    }

    @Test
    public void testGetSourceListId() {
        assertEquals(sourceListId, bidList.getSourceListId());
    }

    @Test
    public void testSetSourceListId() {
        bidList.setSourceListId(sourceListId);
        assertEquals(sourceListId, bidList.getSourceListId());
    }

    @Test
    public void testGetSide() {
        assertEquals(side, bidList.getSide());
    }

    @Test
    public void testSetSide() {
        bidList.setSide(side);
        assertEquals(side, bidList.getSide());
    }

}