package com.nnk.springboot.service.impl;

import com.nnk.springboot.config.CustomUserDetailsService;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.IUserService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The UserService class provides business logic related to User entities.
 */
@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, @Lazy CustomUserDetailsService customUserDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Retrieves all users from the repository.
     * @return A list containing all users.
     */
    public List<User> getUsers(){
        logger.info("Retrieving the list of users");
        return userRepository.findAll();
    }

    /**
     * Retrieves an user by its ID.
     * @param userId The ID of the user to retrieve.
     * @return An Optional containing the user, or an empty Optional if not found.
     */
    public Optional<User> getUserById(int userId){
        logger.info("Retrieving an user by its id");
        verifyUserExistence(userId);
        return userRepository.findById(userId);
    }

    /**
     * Adds a new user to the repository.
     * @param user The User object to be added.
     * @return The added User object.
     */
    @Transactional
    public User addUser(User user){
        logger.info("Adding an user");

        logger.info("Check if the username is unique");
        if(!isUsernameUnique(user.getUsername())) {
            logger.error("Username {} is already in use", user.getUsername());
            throw new EntityExistsException("Username already exists");
        }
        User newUser = new User(
            user.getUsername(),
            passwordEncoder.encode(user.getPassword()),
            user.getFullname(),
            user.getRole()
        );
        return userRepository.save(newUser);
    }

    /**
     * Updates an user in the repository.
     * @param user The User object to be updated.
     * @return The updated User object.
     */
    @Transactional
    public User updateUser(User user){
        logger.info("Updating an user");
        verifyUserExistence(user.getId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Deletes an user by its ID.
     * @param userId The ID of the user to be deleted.
     */
    @Transactional
    public void deleteUserById(int userId){
        logger.info("Deleting an user");
        verifyUserExistence(userId);
        userRepository.deleteById(userId);
    }

    /**
     * Retrieves an user by its username.
     * @param username The username of the user to retrieve.
     * @return An Optional containing the user, or an empty Optional if not found.
     */
    public Optional<User> findByUsername(String username){
        logger.info("Retrieving an user by its username");
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }

    /**
     * This method checks if a User with a given ID exists in the repository.
     *
     * @param id An integer representing the ID of the User.
     * @throws EntityNotFoundException if no User with the provided ID is found in the repository.
     */
    public void verifyUserExistence(int id){
        if(!userRepository.existsById(id)){
            throw new PoseidonEntityNotFoundException("User is not found ", id);
        }
    }

    /**
     * Check if username is unique
     * @param username username for query
     * @return boolean
     */
    public boolean isUsernameUnique(String username){
        logger.info("Checking if an username doesn't already exist");
        int count = userRepository.isUsernameUnique(username);
        return count==0;
    }

}
