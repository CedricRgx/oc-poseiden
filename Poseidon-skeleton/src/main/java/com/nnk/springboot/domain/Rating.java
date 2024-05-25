package com.nnk.springboot.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a Rating in the poseidon application.
 */
@Data
@Entity
@Table(name = "rating")
public class Rating {

    /**
     * Default constructor for the Rating class.
     */
    public Rating() {
    }

    /**
     * Construct a Rating with its attributes
     *
     * @param moodysRating  the Moody's rating to set
     * @param sandPRating   the Standard & Poor's rating to set
     * @param fitchRating   the Fitch rating to set
     * @param orderNumber   the order number to set
     */
    public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber) {
        this.moodysRating = moodysRating;
        this.sandPRating = sandPRating;
        this.fitchRating = fitchRating;
        this.orderNumber = orderNumber;
    }

    /**
     * The unique identifier for the rating.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ratingId")
    private Integer id;

    /**
     * The moodysRating of the rating.
     */
    @Column(name="moodysRating", length=125)
    private String moodysRating;

    /**
     * The sandPRating of the rating.
     */
    @Column(name="sandPRating", length=125)
    private String sandPRating;

    /**
     * The fitchRating of the rating.
     */
    @Column(name="fitchRating", length=125)
    private String fitchRating;

    /**
     * The orderNumber of the rating.
     */
    @Column(name="orderNumber")
    private Integer orderNumber;

}
