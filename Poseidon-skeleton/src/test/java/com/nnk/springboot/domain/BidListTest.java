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
        // Arrange
        bidList = new BidList();

        // Assert
        assertNotNull(bidList);
    }

    @Test
    public void testGetAccount() {
        // Assert
        assertEquals(account, bidList.getAccount());
    }

    @Test
    public void testSetAccount() {
        // Arrange
        bidList.setAccount(account);

        // Assert
        assertEquals(account, bidList.getAccount());
    }

    @Test
    public void testGetType() {
        // Assert
        assertEquals(type, bidList.getType());
    }

    @Test
    public void testSetType() {
        // Arrange
        bidList.setType(type);

        // Assert
        assertEquals(type, bidList.getType());
    }

    @Test
    public void testGetBidQuantity() {
        // Assert
        assertEquals(bidQuantity, bidList.getBidQuantity());
    }

    @Test
    public void testSetBidQuantity() {
        // Arrange
        bidList.setBidQuantity(bidQuantity);

        // Assert
        assertEquals(bidQuantity, bidList.getBidQuantity());
    }

    @Test
    public void testGetAskQuantity() {
        // Assert
        assertEquals(askQuantity, bidList.getAskQuantity());
    }

    @Test
    public void testSetAskQuantity() {
        // Arrange
        bidList.setAskQuantity(askQuantity);

        // Assert
        assertEquals(askQuantity, bidList.getAskQuantity());
    }

    @Test
    public void testGetBid() {
        // Assert
        assertEquals(bid, bidList.getBid());
    }

    @Test
    public void testSetBid() {
        // Arrange
        bidList.setBid(bid);

        // Assert
        assertEquals(bid, bidList.getBid());
    }

    @Test
    public void testGetAsk() {
        // Assert
        assertEquals(ask, bidList.getAsk());
    }

    @Test
    public void testSetAsk() {
        // Arrange
        bidList.setAsk(ask);

        // Assert
        assertEquals(ask, bidList.getAsk());
    }

    @Test
    public void testGetBenchmark() {
        // Assert
        assertEquals(benchmark, bidList.getBenchmark());
    }

    @Test
    public void testSetBenchmark() {
        // Arrange
        bidList.setBenchmark(benchmark);

        // Assert
        assertEquals(benchmark, bidList.getBenchmark());
    }

    @Test
    public void testGetBidListDate() {
        // Assert
        assertEquals(bidListDate, bidList.getBidListDate());
    }

    @Test
    public void testSetBidListDate() {
        // Arrange
        bidList.setBidListDate(bidListDate);

        // Assert
        assertEquals(bidListDate, bidList.getBidListDate());
    }

    @Test
    public void testGetCommentary() {
        // Assert
        assertEquals(commentary, bidList.getCommentary());
    }

    @Test
    public void testSetCommentary() {
        // Arrange
        bidList.setCommentary(commentary);

        // Assert
        assertEquals(commentary, bidList.getCommentary());
    }

    @Test
    public void testGetSecurity() {
        // Assert
        assertEquals(security, bidList.getSecurity());
    }

    @Test
    public void testSetSecurity() {
        // Arrange
        bidList.setSecurity(security);

        // Assert
        assertEquals(security, bidList.getSecurity());
    }

    @Test
    public void testGetStatus() {
        // Assert
        assertEquals(status, bidList.getStatus());
    }

    @Test
    public void testSetStatus() {
        // Arrange
        bidList.setStatus(status);

        // Assert
        assertEquals(status, bidList.getStatus());
    }

    @Test
    public void testGetTrader() {
        // Assert
        assertEquals(trader, bidList.getTrader());
    }

    @Test
    public void testSetTrader() {
        // Arrange
        bidList.setTrader(trader);

        // Assert
        assertEquals(trader, bidList.getTrader());
    }

    @Test
    public void testGetBook() {
        // Assert
        assertEquals(book, bidList.getBook());
    }

    @Test
    public void testSetBook() {
        // Arrange
        bidList.setBook(book);

        // Assert
        assertEquals(book, bidList.getBook());
    }

    @Test
    public void testGetCreationName() {
        // Assert
        assertEquals(creationName, bidList.getCreationName());
    }

    @Test
    public void testSetCreationName() {
        // Arrange
        bidList.setCreationName(creationName);

        // Assert
        assertEquals(creationName, bidList.getCreationName());
    }

    @Test
    public void testGetCreationDate() {
        // Assert
        assertEquals(creationDate, bidList.getCreationDate());
    }

    @Test
    public void testSetCreationDate() {
        // Arrange
        bidList.setCreationDate(creationDate);

        // Assert
        assertEquals(creationDate, bidList.getCreationDate());
    }

    @Test
    public void testGetRevisionName() {
        // Assert
        assertEquals(revisionName, bidList.getRevisionName());
    }

    @Test
    public void testSetRevisionName() {
        // Arrange
        bidList.setRevisionName(revisionName);

        // Assert
        assertEquals(revisionName, bidList.getRevisionName());
    }

    @Test
    public void testGetRevisionDate() {
        // Assert
        assertEquals(revisionDate, bidList.getRevisionDate());
    }

    @Test
    public void testSetRevisionDate() {
        // Arrange
        bidList.setRevisionDate(revisionDate);

        // Assert
        assertEquals(revisionDate, bidList.getRevisionDate());
    }

    @Test
    public void testGetDealName() {
        // Assert
        assertEquals(dealName, bidList.getDealName());
    }

    @Test
    public void testSetDealName() {
        // Arrange
        bidList.setDealName(dealName);

        // Assert
        assertEquals(dealName, bidList.getDealName());
    }

    @Test
    public void testGetDealType() {
        // Assert
        assertEquals(dealType, bidList.getDealType());
    }

    @Test
    public void testSetDealType() {
        // Arrange
        bidList.setDealType(dealType);

        // Assert
        assertEquals(dealType, bidList.getDealType());
    }

    @Test
    public void testGetSourceListId() {
        // Assert
        assertEquals(sourceListId, bidList.getSourceListId());
    }

    @Test
    public void testSetSourceListId() {
        // Arrange
        bidList.setSourceListId(sourceListId);

        // Assert
        assertEquals(sourceListId, bidList.getSourceListId());
    }

    @Test
    public void testGetSide() {
        // Assert
        assertEquals(side, bidList.getSide());
    }

    @Test
    public void testSetSide() {
        // Arrange
        bidList.setSide(side);

        // Assert
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

        // Arrange Assert
        bidListTest1.setAccount("AccountTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setAccount(null);

        bidListTest1.setType("TypeTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setType(null);

        bidListTest1.setBidQuantity(100.00);
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setBidQuantity(0.0);

        bidListTest1.setAskQuantity(200.00);
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setAskQuantity(0.0);

        bidListTest1.setBid(150.00);
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setBid(0.0);

        bidListTest1.setAsk(175.00);
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setAsk(0.0);

        bidListTest1.setBenchmark("BenchmarkTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setBenchmark(null);

        bidListTest1.setBidListDate(Timestamp.valueOf(LocalDate.of(2020, 05, 05).atStartOfDay()));
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setBidListDate(null);

        bidListTest1.setCommentary("CommentaryTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setCommentary(null);

        bidListTest1.setSecurity("SecurityTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setSecurity(null);

        bidListTest1.setStatus("StatusTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setStatus(null);

        bidListTest1.setTrader("TraderTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setTrader(null);

        bidListTest1.setBook("BookTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setBook(null);

        bidListTest1.setCreationName("CreationNameTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setCreationName(null);

        bidListTest1.setCreationDate(Timestamp.valueOf(LocalDate.of(2022, 05, 05).atStartOfDay()));
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setCreationDate(null);

        bidListTest1.setRevisionName("RevisionNameTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setRevisionName(null);

        bidListTest1.setRevisionDate(Timestamp.valueOf(LocalDate.of(2021, 05, 05).atStartOfDay()));
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setRevisionDate(null);

        bidListTest1.setDealName("DealNameTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setDealName(null);

        bidListTest1.setDealType("DealTypeTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setDealType(null);

        bidListTest1.setSourceListId("SourceListIdTest");
        assertNotEquals(bidListTest1, bidListTest2);
        bidListTest1.setSourceListId(null);

        bidListTest1.setSide("SideTest");
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

    @Test
    public void testDefaultConstructor() {
        // Arrange
        bidList = new BidList();

        // Assert
        assertNotNull(bidList);
    }

    @Test
    public void testParameterizedConstructor() {
        // Assert
        assertNotNull(bidList);
        assertEquals(account, bidList.getAccount());
        assertEquals(type, bidList.getType());
        assertEquals(bidQuantity, bidList.getBidQuantity());
    }

    @Test
    public void testFullParameterizedConstructor() {
        // Arrange
        Timestamp now = new Timestamp(System.currentTimeMillis());
        bidList = new BidList(account, type, bidQuantity, 20.0, 100.0, 200.0, "Benchmark", now, "Commentary", "Security", "Status", "Trader", "Book", "CreationName", now, "RevisionName", now, "DealName", "DealType", "SourceListId", "Side");

        // Assert
        assertNotNull(bidList);
        assertEquals(20.0, bidList.getAskQuantity());
        assertEquals(100.0, bidList.getBid());
        assertEquals(200.0, bidList.getAsk());
        assertEquals("Benchmark", bidList.getBenchmark());
        assertEquals(now, bidList.getBidListDate());
        assertEquals("Commentary", bidList.getCommentary());
        assertEquals("Security", bidList.getSecurity());
        assertEquals("Status", bidList.getStatus());
        assertEquals("Trader", bidList.getTrader());
        assertEquals("Book", bidList.getBook());
        assertEquals("CreationName", bidList.getCreationName());
        assertEquals(now, bidList.getCreationDate());
        assertEquals("RevisionName", bidList.getRevisionName());
        assertEquals(now, bidList.getRevisionDate());
        assertEquals("DealName", bidList.getDealName());
        assertEquals("DealType", bidList.getDealType());
        assertEquals("SourceListId", bidList.getSourceListId());
        assertEquals("Side", bidList.getSide());
    }

    @Test
    public void testToStringWithNullValues() {
        // Arrange
        bidList = new BidList(null, null, null);
        String expected = "BidList(id=null, account=null, type=null, bidQuantity=null, askQuantity=null, bid=null, ask=null, benchmark=null, bidListDate=null, commentary=null, security=null, status=null, trader=null, book=null, creationName=null, creationDate=null, revisionName=null, revisionDate=null, dealName=null, dealType=null, sourceListId=null, side=null)";

        // Assert
        assertEquals(expected, bidList.toString());
    }

    @Test
    public void testEqualsAndHashCodeWithNullValues() {
        // Arrange
        bidList = new BidList(null, null, null);
        BidList bidList2 = new BidList(null, null, null);

        // Assert
        assertEquals(bidList, bidList2);
        assertEquals(bidList.hashCode(), bidList2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentValues() {
        // Arrange
        BidList bidList2 = new BidList("DifferentAccount", type, bidQuantity);

        // Assert
        assertNotEquals(bidList, bidList2);
        assertNotEquals(bidList.hashCode(), bidList2.hashCode());
    }

    @Test
    public void testNotEqualsDifferentAccount() {
        // Arrange
        BidList bidList2 = new BidList("DifferentAccount", type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentType() {
        // Arrange
        BidList bidList2 = new BidList(account, "DifferentType", bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentBidQuantity() {
        // Arrange
        BidList bidList2 = new BidList(account, type, 999.99, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentAskQuantity() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, 999.99, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentBid() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, 999.99, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentAsk() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, 999.99, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentBenchmark() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, "DifferentBenchmark", bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentBidListDate() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, Timestamp.valueOf(LocalDate.of(1999, 1, 1).atStartOfDay()), commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentCommentary() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, "DifferentCommentary", security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentSecurity() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, "DifferentSecurity", status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentStatus() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, "DifferentStatus", trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentTrader() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, "DifferentTrader", book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentBook() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, "DifferentBook", creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentCreationName() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, "DifferentCreationName", creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentCreationDate() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, Timestamp.valueOf(LocalDate.of(1999, 1, 1).atStartOfDay()), revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentRevisionName() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, "DifferentRevisionName", revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentRevisionDate() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, Timestamp.valueOf(LocalDate.of(1999, 1, 1).atStartOfDay()), dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentDealName() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, "DifferentDealName", dealType, sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentDealType() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, "DifferentDealType", sourceListId, side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentSourceListId() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, "DifferentSourceListId", side);

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testNotEqualsDifferentSide() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, "DifferentSide");

        // Assert
        assertFalse(bidList.equals(bidList2));
    }

    @Test
    public void testEqualsSameAttributes() {
        // Arrange
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertTrue(bidList.equals(bidList2));
    }

    @Test
    public void testEqualsWithNullFields() {
        // Arrange
        BidList bidList1 = new BidList();
        BidList bidList2 = new BidList();

        // Assert
        assertTrue(bidList1.equals(bidList2));
    }

    @Test
    public void testNotEqualsWithMixedNullFields() {
        // Arrange
        BidList bidList1 = new BidList();
        BidList bidList2 = new BidList(account, type, bidQuantity, askQuantity, bid, ask, benchmark, bidListDate, commentary, security, status, trader, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);

        // Assert
        assertFalse(bidList1.equals(bidList2));
    }

}