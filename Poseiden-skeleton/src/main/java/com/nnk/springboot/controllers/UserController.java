package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            //user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            model.addAttribute("users", userRepository.findAll());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/update";
        }

        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //user.setPassword(encoder.encode(user.getPassword()));
        //user.setId(userId);
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user/list";
    }



    /**
     * This method responds to a GET request at the "/user/list" URL.
     *
     * @return ResponseEntity<List<User>> If the user list is not empty, it returns a response entity with the list of users and HTTP status code 200 (OK).
     * If the user list is empty, it returns a response entity with an empty list and HTTP status code 404 (NOT FOUND).
     **/
    @GetMapping("/user/list")
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("GET request on the endpoint /user/list: getting the list of users");
        List<User> userList = userService.getUsers();
        HttpStatus status;
        if (userList.isEmpty()) {
            logger.error("No users found in the database");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Successfully getting the list of all users");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(userList, status);
    }

    /**
     * This method responds to a GET request at the "/user/id" URL.
     *
     * @return ResponseEntity<User> If the user is not empty, it returns a response entity with the user and HTTP status code 200 (OK).
     * If the user is empty, it returns a response entity with a HTTP status code 404 (NOT FOUND).
     **/
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer userId) {
        logger.info("GET request on the endpoint /user/id: getting the user by its id");
        Optional<User> user = userService.getUserById(userId);
        if (user.isEmpty()) {
            logger.error("No user found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successfully getting the user by its ID");
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
    }

    /**
     * This method responds to a POST request at the "/user/add" URL.
     *
     * @return ResponseEntity<User> If the user has been added, it returns a response entity with the user and HTTP status CREATED.
     * If the user has not been added, it returns a response entity with a HTTP status code BAD_REQUEST.
     **/
    @PostMapping("/user/add")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        logger.info("POST request on the endpoint /user/add: adding an user");
        User userAdded = userService.addUser(user);
        HttpStatus status;
        if (userAdded == null) {
            logger.error("Error adding user");
            status = HttpStatus.BAD_REQUEST;
        }else{
            logger.info("Success adding user");
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(userAdded, status);
    }

    /**
     * This method responds to a PUT request at the "/user/update/{id}" URL.
     *
     * @return ResponseEntity<User> If the user has been updated, it returns a response entity with the user and HTTP status OK.
     * If the user has not been updated, it returns a response entity with a HTTP status code NOT_FOUND.
     **/
    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer userId, @RequestBody User user) {
        logger.info("PUT request on the endpoint /user/update/{id}: updating an user");
        user.setUserId(userId);
        User userUpdated = userService.updateUser(user);
        HttpStatus status;
        if (userUpdated == null) {
            logger.error("Error updating user");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Success updating user");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(userUpdated, status);
    }

    /**
     * This method responds to a DELETE request at the "/user/delete/{id}" URL.
     *
     * @return ResponseEntity<Void> If the user has been deleted, it returns a response entity with HTTP status NO_CONTENT.
     * If the user is not found, it returns a response entity with HTTP status code NOT_FOUND.
     **/
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer userId) {
        logger.info("DELETE request on the endpoint /user/delete/{id}: deleting an user");
        Optional<User> user = userService.getUserById(userId);
        HttpStatus status;
        if (user.isEmpty()) {
            logger.error("Error deleting user: user not found");
            status = HttpStatus.NOT_FOUND;
        }else{
            userService.deleteUserById(userId);
            logger.info("Success deleting user");
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(status);
    }


}
