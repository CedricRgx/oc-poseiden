package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.impl.UserService;
import jakarta.persistence.EntityExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling user in the Poseidon application
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Displays the list of users.
     *
     * @param model The model for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of users.
     */
    @GetMapping("/user/list")
    public String home(Model model){
        logger.info("Loading user list page");

        List<User> users = userService.getUsers();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(users == null) {
            logger.error("Error retrieving users for list page");
        } else {
            logger.info("Successfully retrieved users for list page");
            model.addAttribute("users", users);
            model.addAttribute("user", userDetails);
        }
        return "user/list";
    }

    /**
     * Displays the view to add a user.
     *
     * @param user The user to add for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of users.
     */
    @GetMapping("/user/add")
    public String addUserForm(User user) {
        logger.info("Loading add user form");
        return "user/add";
    }

    /**
     * Handles the POST request to validate and save a user.
     *
     * @param user The user to be validated and saved.
     * @param result The binding result which holds the validation results for the user.
     * @param model The Model object to be used in the view.
     * @return A String indicating the next view. If there are errors, it returns to the add view.
     *         If the user is successfully saved, it redirects to the user view.
     */
    @PostMapping("/user/validate")
    public String validate(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        logger.info("User validation started");
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            logger.error("User validation has errors");
            return "user/add";
        }
        try{
            userService.addUser(user);
            logger.info("User validation finished successfully, User added");
            return "redirect:/user/list";
        }catch(EntityExistsException ex){
            model.addAttribute("usernameError", "Username already exists");
            return "user/add";
        }

    }

    /**
     * Handles the GET request to display the form for updating a user.
     *
     * @param id The id of the user to be updated.
     * @param model The Model object to be used in the view.
     * @return A String that represents the view to be returned.
     *         This is the update view for the user.
     */
    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("Show update form for User with id: " + id);
        Optional<User> bid = userService.getUserById(id);
        if(bid.isPresent()) {
            model.addAttribute("user", bid.get());
        }else{
            logger.warn("User with id: " + id + " not found");
        }
        return "user/update";
    }

    /**
     * Handles the POST request to update a user.
     *
     * @param id The id of the user to be updated.
     * @param user The updated user.
     * @param result The binding result which holds the validation results for the user.
     * @param model The Model object to be used in the view.
     * @return A string indicating the next view. If there are errors, it returns to the update view.
     *         If the bid list is successfully updated, it redirects to the list view.
     */
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model) {
        logger.info("Updating User with id: " + id);
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            logger.error("Error updating User with id: " + id);
            return "user/update";
        }
        userService.updateUser(user);
        logger.info("Updated User with id: " + id);
        return "redirect:/user/list";
    }

    /**
     * Handles the POST request to delete a user by id.
     *
     * @param id    The id of the user to be deleted.
     * @param model The Model object to be used in the view.
     * @return A String that represents the list of user to be returned.
     */
    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        logger.info("Deleting User with id: " + id);
        userService.deleteUserById(id);
        logger.info("Deleted User with id: " + id);
        return "redirect:/user/list";
    }
    
}