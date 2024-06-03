package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testBuilder() {
        // Arrange
        String expected = "RuleName(" +
                "id=null, " +
                "name=nameTest, " +
                "description=descriptionTest, " +
                "json=jsonTest, " +
                "template=templateTest, " +
                "sqlStr=sqlStrTest, " +
                "sqlPart=sqlPartTest" +
                ")";

        // Act Assert
        assertEquals(expected, ruleName.toString());
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        RuleName ruleNameTest = new RuleName();

        // Act
        int initialHashCode = ruleNameTest.hashCode();

        // Assert
        assertEquals(initialHashCode, ruleNameTest.hashCode());
        assertEquals(initialHashCode, ruleNameTest.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();

        // Act Assert
        assertEquals(ruleNameTest1.hashCode(), ruleNameTest2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Act
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();
        ruleNameTest2.setName("DifferentName");

        // Act Assert
        assertNotEquals(ruleNameTest1.hashCode(), ruleNameTest2.hashCode());
    }

    @Test
    public void testHashCodeForNullFields() {
        // Act
        RuleName ruleNameTest = new RuleName();
        ruleNameTest.setName(null);

        // Act
        int hashCodeWithNull = ruleNameTest.hashCode();
        ruleNameTest.setName("NonNullName");
        int hashCodeWithoutNull = ruleNameTest.hashCode();

        // Assert
        assertNotEquals(hashCodeWithNull, hashCodeWithoutNull);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        // Act
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();

        // Assert
        assertEquals(ruleNameTest1.hashCode(), ruleNameTest2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        // Act
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();
        ruleNameTest2.setName("DifferentName");

        // Assert
        assertNotEquals(ruleNameTest1.hashCode(), ruleNameTest2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();
        ruleNameTest1.setName(null);
        ruleNameTest2.setName(null);

        // Assert
        assertEquals(ruleNameTest1.hashCode(), ruleNameTest2.hashCode());

        // Arrange
        ruleNameTest1.setName("NonNullName");
        // Assert
        assertNotEquals(ruleNameTest1.hashCode(), ruleNameTest2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        // Arrange
        RuleName ruleNameTest = new RuleName();

        // Assert
        assertEquals(ruleNameTest, ruleNameTest);
    }

    @Test
    public void testEqualsIdenticalObjects() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();

        // Assert
        assertEquals(ruleNameTest1, ruleNameTest2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();
        ruleNameTest2.setName("DifferentName");

        // Assert
        assertNotEquals(ruleNameTest1, ruleNameTest2);
    }

    @Test
    public void testEqualsNullObject() {
        // Arrange
        RuleName ruleNameTest = new RuleName();

        // Assert
        assertNotEquals(ruleNameTest, null);
    }

    @Test
    public void testEqualsDifferentClassObject() {
        // Arrange
        RuleName ruleNameTest = new RuleName();
        String differentClassObject = "String Test";

        // Assert
        assertNotEquals(ruleNameTest, differentClassObject);
    }

    @Test
    public void testEqualsNullFields() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();
        ruleNameTest1.setName(null);
        ruleNameTest2.setName(null);

        // Assert
        assertEquals(ruleNameTest1, ruleNameTest2);

        // Arrange
        ruleNameTest1.setName("NonNullName");
        // Assert
        assertNotEquals(ruleNameTest1, ruleNameTest2);
    }

    @Test
    public void testEqualsSymmetric() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();

        // Assert
        assertEquals(ruleNameTest1, ruleNameTest2);
        assertEquals(ruleNameTest2, ruleNameTest1);
    }

    @Test
    public void testEqualsTransitive() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();
        RuleName ruleNameTest3 = new RuleName();

        // Assert
        assertEquals(ruleNameTest1, ruleNameTest2);
        assertEquals(ruleNameTest2, ruleNameTest3);
        assertEquals(ruleNameTest1, ruleNameTest3);
    }

    @Test
    public void testEqualsConsistent() {
        // Arrange
        RuleName ruleNameTest1 = new RuleName();
        RuleName ruleNameTest2 = new RuleName();

        // Assert
        assertEquals(ruleNameTest1, ruleNameTest2);
        assertEquals(ruleNameTest1, ruleNameTest2);
        assertEquals(ruleNameTest1, ruleNameTest2);
    }

    @Test
    public void testConstructorWithNullValues() {
        // Arrange
        ruleName = new RuleName(null, null, null, null, null, null);

        // Assert
        assertNull(ruleName.getName());
        assertNull(ruleName.getDescription());
        assertNull(ruleName.getJson());
        assertNull(ruleName.getTemplate());
        assertNull(ruleName.getSqlStr());
        assertNull(ruleName.getSqlPart());
    }

    @Test
    public void testValidationConstraints() {
        // Arrange Assert
        ruleName.setName("a".repeat(126));
        assertFalse(ruleName.getName().length() <= 125);

        // Arrange Assert
        ruleName.setDescription("a".repeat(126));
        assertFalse(ruleName.getDescription().length() <= 125);

        // Arrange Assert
        ruleName.setJson("a".repeat(126));
        assertFalse(ruleName.getJson().length() <= 125);

        // Arrange Assert
        ruleName.setTemplate("a".repeat(126));
        assertFalse(ruleName.getTemplate().length() <= 125);

        // Arrange Assert
        ruleName.setSqlStr("a".repeat(126));
        assertFalse(ruleName.getSqlStr().length() <= 125);

        // Arrange Assert
        ruleName.setSqlPart("a".repeat(126));
        assertFalse(ruleName.getSqlPart().length() <= 125);
    }

    @Test
    public void testToStringWithNullValues() {
        // Arrange
        ruleName = new RuleName(null, null, null, null, null, null);
        String expected = "RuleName(id=null, name=null, description=null, json=null, template=null, sqlStr=null, sqlPart=null)";

        // Assert
        assertEquals(expected, ruleName.toString());
    }

    @Test
    public void testEqualsAndHashCodeWithNullValues() {
        // Arrange
        ruleName = new RuleName(null, null, null, null, null, null);
        RuleName ruleName2 = new RuleName(null, null, null, null, null, null);

        // Assert
        assertEquals(ruleName, ruleName2);
        assertEquals(ruleName.hashCode(), ruleName2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentValues() {
        // Arrange
        RuleName ruleName2 = new RuleName("differentName", description, json, template, sqlStr, sqlPart);

        // Assert
        assertNotEquals(ruleName, ruleName2);
        assertNotEquals(ruleName.hashCode(), ruleName2.hashCode());
    }

}