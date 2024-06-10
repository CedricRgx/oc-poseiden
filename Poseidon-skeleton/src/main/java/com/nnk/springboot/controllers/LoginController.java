package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for handling the login page in the Poseidon application
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Displays the login page and handles potential messages related to login actions.
     *
     * @param model The Model used to pass attributes to the view for rendering.
     * @param error A request parameter indicating that a login error has occurred. Used to show an error message.
     * @param logout A request parameter indicating that the user has successfully logged out. Used to show a logout message.
     * @return The name of the login view template to be rendered.
     */
    @GetMapping("login")
    public String login(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String logout) {
        logger.info("Display the login page");
        if(error!=null){
            model.addAttribute("errorMessage", "Your username or password is incorrect.");}
        if(logout!=null){
            model.addAttribute("logoutMessage", "You have been successfully logged out.");}
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin() {
        return "bidList/list";
    }

    /**
     * Displays the error page
     *
     * @return The name of the 403 error template
     */
    @GetMapping("/error403")
    public String error(Model model) {
        logger.info("Display the error page");
        String errorMessage= "You are not authorized for the requested data.";
        model.addAttribute("errorMsg", errorMessage);
        return "403";
    }
}
