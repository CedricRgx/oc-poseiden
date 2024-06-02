package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for handling the home page in the Poseidon application
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Displays the home page from the root "/".
	 *
	 * @param model The model for the view to add attributes to be rendered on the page.
	 * @return The name of the template to render the home page.
	 */
	@RequestMapping("/")
	public String home(Model model){
		logger.info("Redirect to home page");
		return "home";
	}

	/**
	 * Displays the home page for admin.
	 *
	 * @param model The model for the view to add attributes to be rendered on the page.
	 * @return The name of the template to render the bidlist/list page
	 */
	@GetMapping("/admin/home")
	public String adminHome(Model model){
		logger.info("Display home page");
		return "redirect:/user/list";
	}

}
