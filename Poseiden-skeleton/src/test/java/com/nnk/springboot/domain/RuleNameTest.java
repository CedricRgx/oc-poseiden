package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class RuleNameTest {

    private RuleName ruleName;
    private String name = "nameTest";
    private String description = "descriptionTest";
    private String json = "jsonTest";
    private String template = "templateTest";
    private String sqlStr = "sqlStrTest";
    private String sqlPart = "sqlPartTest";

    @BeforeEach
    public void setUp() {
        ruleName = new RuleName(name, description, json, template, sqlStr, sqlPart);
    }

    @Test
    public void testRuleNameConstructor() {
        ruleName = new RuleName();
        assertNotNull(ruleName);
    }

    @Test
    public void testGetName() {
        assertEquals(name, ruleName.getName());
    }

    @Test
    public void testSetName() {
        ruleName.setName(name);
        assertEquals(name, ruleName.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals(description, ruleName.getDescription());
    }

    @Test
    public void testSetDescription() {
        ruleName.setDescription(description);
        assertEquals(description, ruleName.getDescription());
    }

    @Test
    public void testGetJson() {
        assertEquals(json, ruleName.getJson());
    }

    @Test
    public void testSetJson() {
        ruleName.setJson(json);
        assertEquals(json, ruleName.getJson());
    }

    @Test
    public void testGetTemplate() {
        assertEquals(template, ruleName.getTemplate());
    }

    @Test
    public void testSetTemplate() {
        ruleName.setTemplate(template);
        assertEquals(template, ruleName.getTemplate());
    }

    @Test
    public void testGetSqlStr() {
        assertEquals(sqlStr, ruleName.getSqlStr());
    }

    @Test
    public void testSetSqlStr() {
        ruleName.setSqlStr(sqlStr);
        assertEquals(sqlStr, ruleName.getSqlStr());
    }

    @Test
    public void testGetSqlPart() {
        assertEquals(sqlPart, ruleName.getSqlPart());
    }

    @Test
    public void testSetSqlPart() {
        ruleName.setSqlPart(sqlPart);
        assertEquals(sqlPart, ruleName.getSqlPart());
    }

}