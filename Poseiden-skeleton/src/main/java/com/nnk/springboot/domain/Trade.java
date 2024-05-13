package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Timestamp;

/**
 * Represents a Trade in the Poseiden application.
 */
@Data
@Entity
@Table(name = "trade")
public class Trade {

    /**
     * The unique identifier for the trade.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="TradeId")
    private Integer tradeId;

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
