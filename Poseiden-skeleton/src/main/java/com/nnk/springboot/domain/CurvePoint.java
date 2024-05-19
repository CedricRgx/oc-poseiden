package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Timestamp;

/**
 * Represents a CurvePoint in the Poseiden application.
 */
@Data
@Entity
@Table(name = "curvepoint")
public class CurvePoint {

    /**
     * Default constructor for the CurvePoint class
     */
    public CurvePoint() {
    }

    /**
     * Construct a CurvePoint with its attributes
     *
     * @param asOfDate the reference date
     * @param term  the period of time
     * @param value the value at a given point in time
     * @param creationDate the date at which the value was recorded
     */
    public CurvePoint(Timestamp asOfDate, Double term, Double value, Timestamp creationDate) {
        this.asOfDate = asOfDate;
        this.term = term;
        this.value = value;
        this.creationDate = creationDate;
    }

    /**
     * The unique identifier for the curvepoint.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer curvePointId;

    /**
     * The identifier of the curve of the curvepoint.
     */
    @Column(name="CurveId")
    private Integer curveId;

    /**
     * The as of date of the curvepoint.
     */
    @Column(name="asOfDate")
    private Timestamp asOfDate;

    /**
     * The term of the curvepoint.
     */
    @Column(name="term")
    private Double term;

    /**
     * The value of the curvepoint.
     */
    @Column(name="value")
    private Double value;

    /**
     * The date of creation of the curvepoint.
     */
    @Column(name="creationDate")
    private Timestamp creationDate;

}