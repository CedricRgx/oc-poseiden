package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Timestamp;

/**
 * Represents a Rating in the Poseiden application.
 */
@Data
@Entity
@Table(name = "rating")
public class Rating {

    /**
     * The unique identifier for the rating.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    private Integer ratingId;

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
