package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testBuilder() {
        // Arrange
        String expected = "BidList(" +
                "id=null, " +
                "account=AccountTest, " +
                "type=TypeTest, " +
                "bidQuantity=100.0, " +
                "askQuantity=200.0, " +
                "bid=150.0, " +
                "ask=175.0, " +
                "benchmark=BenchmarkTest, " +
                "bidListDate=2020-05-05 00:00:00.0, " +
                "commentary=CommentaryTest, " +
                "security=SecurityTest, " +
                "status=StatusTest, " +
                "trader=TraderTest, " +
                "book=BookTest, " +
                "creationName=CreationNameTest, " +
                "creationDate=2022-05-05 00:00:00.0, " +
                "revisionName=RevisionNameTest, " +
                "revisionDate=2021-05-05 00:00:00.0, " +
                "dealName=DealNameTest, " +
                "dealType=DealTypeTest, " +
                "sourceListId=SourceListIdTest, " +
                "side=SideTest" +
                ")";

        // Act Assert
        assertEquals(expected, bidList.toString());
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        BidList bidListTest = new BidList();

        // Act
        int initialHashCode = bidListTest.hashCode();

        // Assert
        assertEquals(initialHashCode, bidListTest.hashCode());
        assertEquals(initialHashCode, bidListTest.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();

        // Act Assert
        assertEquals(bidListTest1.hashCode(), bidListTest2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Act
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();
        bidListTest2.setAccount("DifferentAccount");

        // Act Assert
        assertNotEquals(bidListTest1.hashCode(), bidListTest2.hashCode());
    }

    @Test
    public void testHashCodeForNullFields() {
        // Act
        BidList bidListTest = new BidList();
        bidListTest.setAccount(null);

        // Act
        int hashCodeWithNull = bidListTest.hashCode();
        bidListTest.setAccount("NonNullAccount");
        int hashCodeWithoutNull = bidListTest.hashCode();

        // Assert
        assertNotEquals(hashCodeWithNull, hashCodeWithoutNull);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        // Act
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();

        // Assert
        assertEquals(bidListTest1.hashCode(), bidListTest2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        // Act
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();
        bidListTest2.setAccount("DifferentAccount");

        // Assert
        assertNotEquals(bidListTest1.hashCode(), bidListTest2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();
        bidListTest1.setAccount(null);
        bidListTest2.setAccount(null);

        // Assert
        assertEquals(bidListTest1.hashCode(), bidListTest2.hashCode());

        // Arrange
        bidListTest1.setAccount("NonNullAccount");
        // Assert
        assertNotEquals(bidListTest1.hashCode(), bidListTest2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        // Arrange
        BidList bidListTest = new BidList();

        // Assert
        assertEquals(bidListTest, bidListTest);
    }

    @Test
    public void testEqualsIdenticalObjects() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();

        // Assert
        assertEquals(bidListTest1, bidListTest2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();
        bidListTest2.setAccount("DifferentAccount");

        // Assert
        assertNotEquals(bidListTest1, bidListTest2);
    }

    @Test
    public void testEqualsNullObject() {
        // Arrange
        BidList bidListTest = new BidList();

        // Assert
        assertNotEquals(bidListTest, null);
    }

    @Test
    public void testEqualsDifferentClassObject() {
        // Arrange
        BidList bidListTest = new BidList();
        String differentClassObject = "String Test";

        // Assert
        assertNotEquals(bidListTest, differentClassObject);
    }

    @Test
    public void testEqualsNullFields() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();
        bidListTest1.setAccount(null);
        bidListTest2.setAccount(null);

        // Assert
        assertEquals(bidListTest1, bidListTest2);

        // Arrange
        bidListTest1.setAccount("NonNullAccount");
        // Assert
        assertNotEquals(bidListTest1, bidListTest2);
    }

    @Test
    public void testEqualsSymmetric() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();

        // Assert
        assertEquals(bidListTest1, bidListTest2);
        assertEquals(bidListTest2, bidListTest1);
    }

    @Test
    public void testEqualsTransitive() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();
        BidList bidListTest3 = new BidList();

        // Assert
        assertEquals(bidListTest1, bidListTest2);
        assertEquals(bidListTest2, bidListTest3);
        assertEquals(bidListTest1, bidListTest3);
    }

    @Test
    public void testEqualsConsistent() {
        // Arrange
        BidList bidListTest1 = new BidList();
        BidList bidListTest2 = new BidList();

        // Assert
        assertEquals(bidListTest1, bidListTest2);
        assertEquals(bidListTest1, bidListTest2);
        assertEquals(bidListTest1, bidListTest2);
    }

}