package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Timestamp;

/**
 * Represents a BidList in the Poseiden application.
 */
@Data
@Entity
@Table(name = "bidlist")
public class BidList {

    /**
     * The unique identifier for the bidlist.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="BidListId")
    private Integer bidListId;

    /**
     * The account of the bidlist.
     */
    @NotNull
    @Column(name="account", nullable=false, length=30)
    private String account;

    /**
     * The type of the bidlist.
     */
    @NotNull
    @Column(name="type", nullable=false, length=30)
    private String type;

    /**
     * The bidQuantity of the bidlist.
     */
    @Column(name="bidQuantity")
    private Double bidQuantity;

    /**
     * The askQuantity of the bidlist.
     */
    @Column(name="askQuantity")
    private Double askQuantity;

    /**
     * The bid of the bidlist.
     */
    @Column(name="bid")
    private Double bid;

    /**
     * The ask of the bidlist.
     */
    @Column(name="ask")
    private Double ask;

    /**
     * The benchmark of the bidlist.
     */
    @Column(name="benchmark", length=125)
    private String benchmark;

    /**
     * The bidListDate of the bidlist.
     */
    @Column(name="bidListDate")
    private Timestamp bidListDate;

    /**
     * The commentary of the bidlist.
     */
    @Column(name="commentary", length=125)
    private String commentary;

    /**
     * The security of the bidlist.
     */
    @Column(name="security", length=125)
    private String security;

    /**
     * The status of the bidlist.
     */
    @Column(name="status", length=10)
    private String status;

    /**
     * The trader of the bidlist.
     */
    @Column(name="trader", length=125)
    private String trader;

    /**
     * The book of the bidlist.
     */
    @Column(name="book", length=125)
    private String book;

    /**
     * The name of creation of the bidlist.
     */
    @Column(name="creationName", length=125)
    private String creationName;

    /**
     * The date of creation of the bidlist.
     */
    @Column(name="creationDate")
    private Timestamp creationDate;

    /**
     * The name of revision of the bidlist.
     */
    @Column(name="revisionName", length=125)
    private String revisionName;

    /**
     * The date of revision of the bidlist.
     */
    @Column(name="revisionDate")
    private Timestamp revisionDate;

    /**
     * The name of deal of the bidlist.
     */
    @Column(name="dealName", length=125)
    private String dealName;

    /**
     * The type of deal of the bidlist.
     */
    @Column(name="dealType", length=125)
    private String dealType;

    /**
     * The identifier of the list of source of the bidlist.
     */
    @Column(name="sourceListId", length=125)
    private String sourceListId;

    /**
     * The side of the bidlist.
     */
    @Column(name="side", length=125)
    private String side;


}
