package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Timestamp;

/**
 * Represents a Trade in the poseidon application.
 */
@Data
@Entity
@Table(name = "trade")
public class Trade {

    /**
     * Default constructor for the Trade class
     */
    public Trade() {
    }

    /**
     * Construct a Trade with its attributes
     *
     * @param account       the account name
     * @param type          the type of trade
     * @param buyQuantity   the quantity of buy
     * @param sellQuantity  the quantity of sell
     * @param buyPrice      the price of buy
     * @param sellPrice     the price of sell
     * @param tradeDate     the date of trade
     * @param security      the security for trade
     * @param status        the status of trade
     * @param trader        the name of trader
     * @param benchmark     the benchmark for trade
     * @param book          the book of trade
     * @param creationName  the name of creator
     * @param creationDate  the date of creation
     * @param revisionName  the name of revision
     * @param revisionDate  the date of revision
     * @param dealName      the name of deal
     * @param dealType      the type of deal
     * @param sourceListId  the id of source list
     * @param side          the side of trade
     */
    public Trade(String account, String type, Double buyQuantity, Double sellQuantity, Double buyPrice, Double sellPrice, Timestamp tradeDate, String security, String status, String trader, String benchmark, String book, String creationName, Timestamp creationDate, String revisionName, Timestamp revisionDate, String dealName, String dealType, String sourceListId, String side) {
        this.account = account;
        this.type = type;
        this.buyQuantity = buyQuantity;
        this.sellQuantity = sellQuantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.tradeDate = tradeDate;
        this.security = security;
        this.status = status;
        this.trader = trader;
        this.benchmark = benchmark;
        this.book = book;
        this.creationName = creationName;
        this.creationDate = creationDate;
        this.revisionName = revisionName;
        this.revisionDate = revisionDate;
        this.dealName = dealName;
        this.dealType = dealType;
        this.sourceListId = sourceListId;
        this.side = side;
    }

    /**
     * The unique identifier for the trade.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="tradeId")
    private Integer id;

    /**
     * The account of the trade.
     */
    @NotNull
    @Column(name="account", nullable=false, length=30)
    private String account;

    /**
     * The type of the trade.
     */
    @NotNull
    @Column(name="type", nullable=false, length=30)
    private String type;

    /**
     * The quantity to buy of the trade.
     */
    @Column(name="buyQuantity")
    private Double buyQuantity;

    /**
     * The quantity to sell of the trade.
     */
    @Column(name="sellQuantity")
    private Double sellQuantity;

    /**
     * The date of creation of the trade.
     */
    @Column(name="buyPrice")
    private Double buyPrice;

    /**
     * The price of sell of the trade.
     */
    @Column(name="sellPrice")
    private Double sellPrice;

    /**
     * The date of the trade.
     */
    @Column(name="tradeDate")
    private Timestamp tradeDate;

    /**
     * The security of the trade.
     */
    @Column(name="security", length=125)
    private String security;

    /**
     * The status of the trade.
     */
    @Column(name="status", length=10)
    private String status;

    /**
     * The trader of the trade.
     */
    @Column(name="trader", length=125)
    private String trader;

    /**
     * The benchmark of the trade.
     */
    @Column(name="benchmark", length=125)
    private String benchmark;

    /**
     * The book of the trade.
     */
    @Column(name="book", length=125)
    private String book;

    /**
     * The name of creation of the trade.
     */
    @Column(name="creationName", length=125)
    private String creationName;

    /**
     * The date of creation of the trade.
     */
    @Column(name="creationDate")
    private Timestamp creationDate;

    /**
     * The name of revision of the trade.
     */
    @Column(name="revisionName", length=125)
    private String revisionName;

    /**
     * The date of revision of the trade.
     */
    @Column(name="revisionDate")
    private Timestamp revisionDate;

    /**
     * The name of deal of the trade.
     */
    @Column(name="dealName", length=125)
    private String dealName;

    /**
     * The type of deal of the trade.
     */
    @Column(name="dealType", length=125)
    private String dealType;

    /**
     * The identifier of the list of source of the trade.
     */
    @Column(name="sourceListId", length=125)
    private String sourceListId;

    /**
     * The side of the trade.
     */
    @Column(name="side", length=125)
    private String side;

}
