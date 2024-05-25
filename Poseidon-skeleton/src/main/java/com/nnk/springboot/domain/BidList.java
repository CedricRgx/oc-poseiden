package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.sql.Timestamp;

/**
 * Represents a BidList in the poseidon application.
 */
@Data
@Entity
@Table(name = "bidlist")
public class BidList {

    /**
     * Default constructor to create an instance of BidList.
     */
    public BidList() {
    }

    /**
     * Constructor to create an instance of BidList with provided details.
     *
     * @param account        the account identifier.
     * @param type           the type of bid.
     * @param bidQuantity    the quantity of bid.
     * @param askQuantity    the quantity of ask.
     * @param bid            the bid amount.
     * @param ask            the ask amount.
     * @param benchmark      the benchmark.
     * @param bidListDate    the date of bid list.
     * @param commentary     the commentary.
     * @param security       the security identifier.
     * @param status         the status of bid.
     * @param trader         the trader identifier.
     * @param book           the book.
     * @param creationName   the creation name.
     * @param creationDate   the creation date.
     * @param revisionName   the revision name.
     * @param revisionDate   the revision date.
     * @param dealName       the deal name.
     * @param dealType       the deal type.
     * @param sourceListId   the source list identifier.
     * @param side           the side of bid/ask.
     */
    public BidList(String account, String type, Double bidQuantity, Double askQuantity, Double bid, Double ask, String benchmark, Timestamp bidListDate, String commentary, String security, String status, String trader, String book, String creationName, Timestamp creationDate, String revisionName, Timestamp revisionDate, String dealName, String dealType, String sourceListId, String side) {
        this.account = account;
        this.type = type;
        this.bidQuantity = bidQuantity;
        this.askQuantity = askQuantity;
        this.bid = bid;
        this.ask = ask;
        this.benchmark = benchmark;
        this.bidListDate = bidListDate;
        this.commentary = commentary;
        this.security = security;
        this.status = status;
        this.trader = trader;
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
     * The unique identifier for the bidlist.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name= "bidListId")
    private Integer id;

    /**
     * The account of the bidlist.
     */
    @NotNull(message="{account.notnull}")
    @NotEmpty(message="{account.notempty}")
    @Size(max=30)
    @Column(name="account")
    private String account;

    /**
     * The type of the bidlist.
     */
    @NotNull(message="{type.notnull}")
    @NotEmpty(message="{type.notempty}")
    @Size(max=30)
    @Column(name="type")
    private String type;

    /**
     * The bidQuantity of the bidlist.
     */
    @NotNull(message="{bidQuantity.notnull}")
    @Column(name= "bidQuantity")
    private Double bidQuantity;

    /**
     * The askQuantity of the bidlist.
     */
    @Column(name= "askQuantity")
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
    @Column(name= "bidListDate")
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
    @Column(name= "creationName", length=125)
    private String creationName;

    /**
     * The date of creation of the bidlist.
     */
    @Column(name= "creationDate")
    private Timestamp creationDate;

    /**
     * The name of revision of the bidlist.
     */
    @Column(name= "revisionName", length=125)
    private String revisionName;

    /**
     * The date of revision of the bidlist.
     */
    @Column(name= "revisionDate")
    private Timestamp revisionDate;

    /**
     * The name of deal of the bidlist.
     */
    @Column(name= "dealName", length=125)
    private String dealName;

    /**
     * The type of deal of the bidlist.
     */
    @Column(name= "dealType", length=125)
    private String dealType;

    /**
     * The identifier of the list of source of the bidlist.
     */
    @Column(name= "sourceListId", length=125)
    private String sourceListId;

    /**
     * The side of the bidlist.
     */
    @Column(name="side", length=125)
    private String side;

}
