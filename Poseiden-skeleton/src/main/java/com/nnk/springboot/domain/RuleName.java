package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Represents a RuleName in the Poseiden application.
 */
@Data
@Entity
@Table(name = "rulename")
public class RuleName {

    /**
     * The unique identifier for the rulename.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    private Integer rulenameId;

    /**
     * The name of the rulename.
     */
    @Column(name="name", length=125)
    private String name;

    /**
     * The description of the rulename.
     */
    @Column(name="description", length=125)
    private String description;

    /**
     * The json of the rulename.
     */
    @Column(name="json", length=125)
    private String json;

    /**
     * The template of the rulename.
     */
    @Column(name="template", length=125)
    private String template;

    /**
     * The sqlStr of the rulename.
     */
    @Column(name="sqlStr", length=125)
    private String sqlStr;

    /**
     * The sqlPart of the rulename.
     */
    @Column(name="sqlPart", length=125)
    private String sqlPart;

}
