package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

/**
 * Interface for services related to users within the poseidon application.
 */
public interface IUserService {

    /**
     * Retrieves all users from the repository.
     * @return A list containing all users.
     */
    public List<User> getUsers();

    /**
     * Retrieves a user by its ID.
     * @param userId The ID of the user to retrieve.
     * @return An Optional containing the user, or an empty Optional if not found.
     */
    public Optional<User> getUserById(int userId);

    /**
     * Adds a new user to the repository.
     * @param user The User object to be added.
     * @return The added User object.
     */
    public User addUser(User user);

    /**
     * Updates an user in the repository.
     * @param user The User object to be updated.
     * @return The updated User object.
     */
    public User updateUser(User user);

    /**
     * Deletes a user by their ID.
     * @param userId The ID of the user to be deleted.
     */
    public void deleteUserById(int userId);

}