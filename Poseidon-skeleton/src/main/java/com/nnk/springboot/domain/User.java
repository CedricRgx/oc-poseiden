package com.nnk.springboot.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Represents a User in the poseidon application.
 */
@Data
@Entity
@Table(name = "users")
public class User {

    /**
     * Default constructor for User.
     *
     * Initialized a new User object with no properties set.
     */
    public User() {
    }

    /**
     * Construct a User with its attributes
     *
     * @param username User's username.
     * @param password User's password.
     * @param fullname User's full name.
     * @param role     User's role.
     */
    public User(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userId")
    private Integer id;

    /**
     * The username of the user.
     */
    @NotBlank(message = "Username is mandatory")
    @Column(name="username", length=125)
    private String username;

    /**
     * The password of the user.
     */
    @NotBlank(message = "Password is mandatory")
    @Column(name="password", length=125)
    private String password;

    /**
     * The fullname of the user.
     */
    @NotBlank(message = "FullName is mandatory")
    @Column(name="fullname", length=125)
    private String fullname;

    /**
     * The role of the user.
     */
    @NotBlank(message = "Role is mandatory")
    @Column(name="role", length=125)
    private String role;

}
