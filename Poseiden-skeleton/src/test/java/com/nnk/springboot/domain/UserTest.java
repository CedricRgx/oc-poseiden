package com.nnk.springboot.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user;
    private Integer userId = 1;
    private String username = "username";
    private String password = "password";
    private String fullname = "fullname";
    private String role = "role";

    @BeforeEach
    public void setUp() {
        user = new User(userId, username, password, fullname, role);
    }

    @Test
    public void testGetId() {
        assertEquals(userId, user.getUserId());
    }

    @Test
    public void testSetId() {
        user.setUserId(userId);
        assertEquals(userId, user.getUserId());
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
    public void setFullnameTest() {
        user.setFullname(fullname);
        assertEquals(fullname, user.getFullname());
    }

    @Test
    public void testGetRole() {
        assertEquals(role, user.getRole());
    }

    @Test
    public void setRoleTest() {
        user.setRole(role);
        assertEquals(role, user.getRole());
    }
}
