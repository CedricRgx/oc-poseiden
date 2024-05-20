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
     * Default constructor for the RuleName class
     */
    public RuleName() {
    }

    /**
     * Construct a RuleName with its attributes
     *
     * @param name        the name of the rule
     * @param description a description of the rule
     * @param json        JSON related to the rule
     * @param template    the template used by the rule
     * @param sqlStr      an SQL string pertaining to the rule
     * @param sqlPart     part of an SQL statement related to the rule
     */
    public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
        this.name = name;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sqlStr;
        this.sqlPart = sqlPart;
    }

    /**
     * The unique identifier for the rulename.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private Integer ruleNameId;

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
