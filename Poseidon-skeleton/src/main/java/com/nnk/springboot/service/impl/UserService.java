package com.nnk.springboot.service.impl;

import com.nnk.springboot.controllers.UserController;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return userRepository.save(user);
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
        if(user == null){
            throw new EntityNotFoundException("User not found");
        }
        return user;
    }

    /**
     * This method checks if a User with a given ID exists in the repository.
     *
     * @param id An integer representing the ID of the User.
     * @throws EntityNotFoundException if no User with the provided ID is found in the repository.
     */
    private void verifyUserExistence(int id){
        if(!userRepository.existsById(id)){
            throw new PoseidonEntityNotFoundException("User is not found ", id);
        }
    }

}
