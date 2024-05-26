package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Represents a RuleName in the poseidon application.
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
    @Column(name="ruleNameId")
    private Integer id;

    /**
     * The name of the rulename.
     */
    @Size(max=125, message = "{name.size}")
    @Column(name="name")
    private String name;

    /**
     * The description of the rulename.
     */
    @Size(max=125, message = "{description.size}")
    @Column(name="description")
    private String description;

    /**
     * The json of the rulename.
     */
    @Size(max=125, message = "{json.size}")
    @Column(name="json")
    private String json;

    /**
     * The template of the rulename.
     */
    @Size(max=125, message = "{template.size}")
    @Column(name="template")
    private String template;

    /**
     * The sqlStr of the rulename.
     */
    @Size(max=125, message = "{sqlStr.size}")
    @Column(name="sqlStr")
    private String sqlStr;

    /**
     * The sqlPart of the rulename.
     */
    @Size(max=125, message = "{sqlPart.size}")
    @Column(name="sqlPart")
    private String sqlPart;

}
