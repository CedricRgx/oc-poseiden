package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TradeTest {

    private Trade trade;
    private String account = "AccountTest";
    private String type = "TypeTest";
    private double buyQuantity = 100.00;
    private double sellQuantity = 200.00;
    private double buyPrice = 150.00;
    private double sellPrice = 175.00;
    private Timestamp tradeDate = Timestamp.valueOf(LocalDate.of(2020, 05, 05).atStartOfDay());
    private String security = "SecurityTest";
    private String status = "StatusTest";
    private String trader = "TraderTest";
    private String benchmark = "BenchmarkTest";
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
        trade = new Trade(account, type, buyQuantity, sellQuantity, buyPrice, sellPrice, tradeDate, security, status, trader, benchmark, book, creationName, creationDate, revisionName, revisionDate, dealName, dealType, sourceListId, side);
    }

    @Test
    public void testRuleNameConstructor() {
        trade = new Trade();
        assertNotNull(trade);
    }

    @Test
    public void testGetAccount() {
        assertEquals(account, trade.getAccount());
    }

    @Test
    public void testSetAccount() {
        trade.setAccount(account);
        assertEquals(account, trade.getAccount());
    }

    @Test
    public void testGetType() {
        assertEquals(type, trade.getType());
    }

    @Test
    public void testSetType() {
        trade.setType(type);
        assertEquals(type, trade.getType());
    }

    @Test
    public void testGetBuyQuantity() {
        assertEquals(buyQuantity, trade.getBuyQuantity());
    }

    @Test
    public void testSetBidQuantity() {
        trade.setBuyQuantity(buyQuantity);
        assertEquals(buyQuantity, trade.getBuyQuantity());
    }

    @Test
    public void testGetSellQuantity() {
        assertEquals(sellQuantity, trade.getSellQuantity());
    }

    @Test
    public void testSetAskQuantity() {
        trade.setSellQuantity(sellQuantity);
        assertEquals(sellQuantity, trade.getSellQuantity());
    }

    @Test
    public void testGetBuyPrice() {
        assertEquals(buyPrice, trade.getBuyPrice());
    }

    @Test
    public void testSetBuyPrice() {
        trade.setBuyPrice(buyPrice);
        assertEquals(buyPrice, trade.getBuyPrice());
    }

    @Test
    public void testGetSellPrice() {
        assertEquals(sellPrice, trade.getSellPrice());
    }

    @Test
    public void testSetSellPrice() {
        trade.setSellPrice(sellPrice);
        assertEquals(sellPrice, trade.getSellPrice());
    }

    @Test
    public void testGetTradeDate() {
        assertEquals(tradeDate, trade.getTradeDate());
    }

    @Test
    public void testSetTradeDate() {
        trade.setTradeDate(tradeDate);
        assertEquals(tradeDate, trade.getTradeDate());
    }

    @Test
    public void testGetSecurity() {
        assertEquals(security, trade.getSecurity());
    }

    @Test
    public void testSetSecurity() {
        trade.setSecurity(security);
        assertEquals(security, trade.getSecurity());
    }

    @Test
    public void testGetStatus() {
        assertEquals(status, trade.getStatus());
    }

    @Test
    public void testSetStatus() {
        trade.setStatus(status);
        assertEquals(status, trade.getStatus());
    }

    @Test
    public void testGetTrader() {
        assertEquals(trader, trade.getTrader());
    }

    @Test
    public void testSetTrader() {
        trade.setTrader(trader);
        assertEquals(trader, trade.getTrader());
    }

    @Test
    public void testGetBenchmark() {
        assertEquals(benchmark, trade.getBenchmark());
    }

    @Test
    public void testSetBenchmark() {
        trade.setBenchmark(benchmark);
        assertEquals(benchmark, trade.getBenchmark());
    }

    @Test
    public void testGetBook() {
        assertEquals(book, trade.getBook());
    }

    @Test
    public void testSetBook() {
        trade.setBook(book);
        assertEquals(book, trade.getBook());
    }

    @Test
    public void testGetCreationName() {
        assertEquals(creationName, trade.getCreationName());
    }

    @Test
    public void testSetCreationName() {
        trade.setCreationName(creationName);
        assertEquals(creationName, trade.getCreationName());
    }

    @Test
    public void testGetCreationDate() {
        assertEquals(creationDate, trade.getCreationDate());
    }

    @Test
    public void testSetCreationDate() {
        trade.setCreationDate(creationDate);
        assertEquals(creationDate, trade.getCreationDate());
    }

    @Test
    public void testGetRevisionName() {
        assertEquals(revisionName, trade.getRevisionName());
    }

    @Test
    public void testSetRevisionName() {
        trade.setRevisionName(revisionName);
        assertEquals(revisionName, trade.getRevisionName());
    }

    @Test
    public void testGetRevisionDate() {
        assertEquals(revisionDate, trade.getRevisionDate());
    }

    @Test
    public void testSetRevisionDate() {
        trade.setRevisionDate(revisionDate);
        assertEquals(revisionDate, trade.getRevisionDate());
    }

    @Test
    public void testGetDealName() {
        assertEquals(dealName, trade.getDealName());
    }

    @Test
    public void testSetDealName() {
        trade.setDealName(dealName);
        assertEquals(dealName, trade.getDealName());
    }

    @Test
    public void testGetDealType() {
        assertEquals(dealType, trade.getDealType());
    }

    @Test
    public void testSetDealType() {
        trade.setDealType(dealType);
        assertEquals(dealType, trade.getDealType());
    }

    @Test
    public void testGetSourceListId() {
        assertEquals(sourceListId, trade.getSourceListId());
    }

    @Test
    public void testSetSourceListId() {
        trade.setSourceListId(sourceListId);
        assertEquals(sourceListId, trade.getSourceListId());
    }

    @Test
    public void testGetSide() {
        assertEquals(side, trade.getSide());
    }

    @Test
    public void testSetSide() {
        trade.setSide(side);
        assertEquals(side, trade.getSide());
    }

    @Test
    public void testBuilder() {
        // Arrange
        String expected = "Trade(" +
                "id=null, " +
                "account=AccountTest, " +
                "type=TypeTest, " +
                "buyQuantity=100.0, " +
                "sellQuantity=200.0, " +
                "buyPrice=150.0, " +
                "sellPrice=175.0, " +
                "tradeDate=2020-05-05 00:00:00.0, " +
                "security=SecurityTest, " +
                "status=StatusTest, " +
                "trader=TraderTest, " +
                "benchmark=BenchmarkTest, " +
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
        assertEquals(expected, trade.toString());
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        Trade tradeTest = new Trade();

        // Act
        int initialHashCode = tradeTest.hashCode();

        // Assert
        assertEquals(initialHashCode, tradeTest.hashCode());
        assertEquals(initialHashCode, tradeTest.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();

        // Act Assert
        assertEquals(tradeTest1.hashCode(), tradeTest2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Act
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();
        tradeTest2.setAccount("DifferentAccount");

        // Act Assert
        assertNotEquals(tradeTest1.hashCode(), tradeTest2.hashCode());
    }

    @Test
    public void testHashCodeForNullFields() {
        // Act
        Trade tradeTest = new Trade();
        tradeTest.setAccount(null);

        // Act
        int hashCodeWithNull = tradeTest.hashCode();
        tradeTest.setAccount("NonNullAccount");
        int hashCodeWithoutNull = tradeTest.hashCode();

        // Assert
        assertNotEquals(hashCodeWithNull, hashCodeWithoutNull);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        // Act
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();

        // Assert
        assertEquals(tradeTest1.hashCode(), tradeTest2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        // Act
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();
        tradeTest2.setAccount("DifferentAccount");

        // Assert
        assertNotEquals(tradeTest1.hashCode(), tradeTest2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();
        tradeTest1.setAccount(null);
        tradeTest2.setAccount(null);

        // Assert
        assertEquals(tradeTest1.hashCode(), tradeTest2.hashCode());

        // Arrange
        tradeTest1.setAccount("NonNullAccount");
        // Assert
        assertNotEquals(tradeTest1.hashCode(), tradeTest2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        // Arrange
        Trade tradeTest = new Trade();

        // Assert
        assertEquals(tradeTest, tradeTest);
    }

    @Test
    public void testEqualsIdenticalObjects() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();

        // Assert
        assertEquals(tradeTest1, tradeTest2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();
        tradeTest2.setAccount("DifferentAccount");

        // Assert
        assertNotEquals(tradeTest1, tradeTest2);
    }

    @Test
    public void testEqualsNullObject() {
        // Arrange
        Trade tradeTest = new Trade();

        // Assert
        assertNotEquals(tradeTest, null);
    }

    @Test
    public void testEqualsDifferentClassObject() {
        // Arrange
        Trade tradeTest = new Trade();
        String differentClassObject = "String Test";

        // Assert
        assertNotEquals(tradeTest, differentClassObject);
    }

    @Test
    public void testEqualsNullFields() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();
        tradeTest1.setAccount(null);
        tradeTest2.setAccount(null);

        // Assert
        assertEquals(tradeTest1, tradeTest2);

        // Arrange
        tradeTest1.setAccount("NonNullAccount");
        // Assert
        assertNotEquals(tradeTest1, tradeTest2);
    }

    @Test
    public void testEqualsSymmetric() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();

        // Assert
        assertEquals(tradeTest1, tradeTest2);
        assertEquals(tradeTest2, tradeTest1);
    }

    @Test
    public void testEqualsTransitive() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();
        Trade tradeTest3 = new Trade();

        // Assert
        assertEquals(tradeTest1, tradeTest2);
        assertEquals(tradeTest2, tradeTest3);
        assertEquals(tradeTest1, tradeTest3);
    }

    @Test
    public void testEqualsConsistent() {
        // Arrange
        Trade tradeTest1 = new Trade();
        Trade tradeTest2 = new Trade();

        // Assert
        assertEquals(tradeTest1, tradeTest2);
        assertEquals(tradeTest1, tradeTest2);
        assertEquals(tradeTest1, tradeTest2);
    }
}
