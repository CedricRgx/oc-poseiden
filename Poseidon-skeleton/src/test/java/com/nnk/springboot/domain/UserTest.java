package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user;
    private String username = "username";
    private String password = "password";
    private String fullname = "fullname";
    private String role = "role";

    @BeforeEach
    public void setUp() {
        user = new User(username, password, fullname, role);
    }

    @Test
    public void testUserConstructor() {
        user = new User();
        assertNotNull(user);
    }

    @Test
    public void testGetUsername() {
        assertEquals(username, user.getUsername());
    }

    @Test
    public void testSetUsername() {
        user.setUsername(username);
        assertEquals(username, user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testGetFullname() {
        assertEquals(fullname, user.getFullname());
    }

    @Test
    public void testSetFullname() {
        user.setFullname(fullname);
        assertEquals(fullname, user.getFullname());
    }

    @Test
    public void testGetRole() {
        assertEquals(role, user.getRole());
    }

    @Test
    public void testSetRole() {
        user.setRole(role);
        assertEquals(role, user.getRole());
    }

    @Test
    public void testBuilder() {
        // Arrange
        String expected = "User(" +
                "id=null, " +
                "username=username, " +
                "password=password, " +
                "fullname=fullname, " +
                "role=role" +
                ")";

        // Act Assert
        assertEquals(expected, user.toString());
    }

    @Test
    public void testHashCodeConsistency() {
        // Arrange
        User userTest = new User();

        // Act
        int initialHashCode = userTest.hashCode();

        // Assert
        assertEquals(initialHashCode, userTest.hashCode());
        assertEquals(initialHashCode, userTest.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();

        // Act Assert
        assertEquals(userTest1.hashCode(), userTest2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        // Act
        User userTest1 = new User();
        User userTest2 = new User();
        userTest2.setFullname("DifferentFullname");

        // Act Assert
        assertNotEquals(userTest1.hashCode(), userTest2.hashCode());
    }

    @Test
    public void testHashCodeForNullFields() {
        // Act
        User userTest = new User();
        userTest.setFullname(null);

        // Act
        int hashCodeWithNull = userTest.hashCode();
        userTest.setFullname("NonNullFullname");
        int hashCodeWithoutNull = userTest.hashCode();

        // Assert
        assertNotEquals(hashCodeWithNull, hashCodeWithoutNull);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        // Act
        User userTest1 = new User();
        User userTest2 = new User();

        // Assert
        assertEquals(userTest1.hashCode(), userTest2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        // Act
        User userTest1 = new User();
        User userTest2 = new User();
        userTest2.setFullname("DifferentFullname");

        // Assert
        assertNotEquals(userTest1.hashCode(), userTest2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();
        userTest1.setFullname(null);
        userTest2.setFullname(null);

        // Assert
        assertEquals(userTest1.hashCode(), userTest2.hashCode());

        // Arrange
        userTest1.setFullname("NonNullFullname");
        // Assert
        assertNotEquals(userTest1.hashCode(), userTest2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        // Arrange
        User userTest = new User();

        // Assert
        assertEquals(userTest, userTest);
    }

    @Test
    public void testEqualsIdenticalObjects() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();

        // Assert
        assertEquals(userTest1, userTest2);
    }

    @Test
    public void testEqualsDifferentObjects() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();
        userTest2.setFullname("DifferentFullname");

        // Assert
        assertNotEquals(userTest1, userTest2);
    }

    @Test
    public void testEqualsNullObject() {
        // Arrange
        User userTest = new User();

        // Assert
        assertNotEquals(userTest, null);
    }

    @Test
    public void testEqualsDifferentClassObject() {
        // Arrange
        User userTest = new User();
        String differentClassObject = "String Test";

        // Assert
        assertNotEquals(userTest, differentClassObject);
    }

    @Test
    public void testEqualsNullFields() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();
        userTest1.setFullname(null);
        userTest2.setFullname(null);

        // Assert
        assertEquals(userTest1, userTest2);

        // Arrange
        userTest1.setFullname("NonNullFullname");
        // Assert
        assertNotEquals(userTest1, userTest2);
    }

    @Test
    public void testEqualsSymmetric() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();

        // Assert
        assertEquals(userTest1, userTest2);
        assertEquals(userTest2, userTest1);
    }

    @Test
    public void testEqualsTransitive() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();
        User userTest3 = new User();

        // Assert
        assertEquals(userTest1, userTest2);
        assertEquals(userTest2, userTest3);
        assertEquals(userTest1, userTest3);
    }

    @Test
    public void testEqualsConsistent() {
        // Arrange
        User userTest1 = new User();
        User userTest2 = new User();

        // Assert
        assertEquals(userTest1, userTest2);
        assertEquals(userTest1, userTest2);
        assertEquals(userTest1, userTest2);
    }
}
