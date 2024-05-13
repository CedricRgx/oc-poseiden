package com.nnk.springboot.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Represents a User in the Poseiden application.
 */
@Data
@Entity
@Table(name = "users")
public class User {

    /**
     * The unique identifier for the user.
     */
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="Id")
    private Integer userId;

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
