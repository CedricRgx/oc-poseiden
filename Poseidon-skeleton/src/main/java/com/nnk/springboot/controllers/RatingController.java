package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.impl.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling rating in the Poseidon application
 */
@Controller
public class RatingController {
    
    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);
    
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    
    /**
     * Displays the list of ratings.
     *
     * @param model The model for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of ratings.
     */
    @GetMapping("/rating/list")
    public String home(Model model){
        logger.info("Loading rating list page");
        List<Rating> ratings = ratingService.getRatings();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(ratings == null) {
            logger.error("Error retrieving ratings for list page");
        } else {
            logger.info("Successfully retrieved ratings for list page");
            model.addAttribute("ratings", ratings);
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                model.addAttribute("user", userDetails);
            } else if (principal instanceof DefaultOAuth2User) {
                DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
                model.addAttribute("user", oauth2User.getAttributes());
            }
        }
        return "rating/list";
    }

    /**
     * Displays the view to add a rating.
     *
     * @param rating The rating to add for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of ratings.
     */
    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        logger.info("Loading add rating form");
        return "rating/add";
    }

    /**
     * Handles the POST request to validate and save a rating.
     *
     * @param rating The rating to be validated and saved.
     * @param result The binding result which holds the validation results for the rating.
     * @param model The Model object to be used in the view.
     * @return A String indicating the next view. If there are errors, it returns to the add view.
     *         If the rating point is successfully saved, it redirects to the rating view.
     */
    @PostMapping("/rating/validate")
    public String validate(@Valid @ModelAttribute("rating") Rating rating, BindingResult result, Model model) {
        logger.info("Rating validation started");
        if(result.hasErrors()) {
            model.addAttribute("rating", rating);
            logger.error("Rating validation has errors");
            return "rating/add";
        }
        ratingService.addRating(rating);
        logger.info("Rating validation finished successfully, Rating added");
        return "redirect:/rating/list";
    }

    /**
     * Handles the GET request to display the form for updating a rating.
     *
     * @param id The id of the rating point to be updated.
     * @param model The Model object to be used in the view.
     * @return A String that represents the view to be returned.
     *         This is the update view for the rating point.
     */
    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("Show update form for Rating with id: " + id);
        Optional<Rating> bid = ratingService.getRatingById(id);
        if(bid.isPresent()) {
            model.addAttribute("rating", bid.get());
        }else{
            logger.warn("Rating with id: " + id + " not found");
        }
        return "rating/update";
    }

    /**
     * Handles the POST request to update a rating.
     *
     * @param id The id of the rating point to be updated.
     * @param rating The updated rating.
     * @param result The binding result which holds the validation results for the rating.
     * @param model The Model object to be used in the view.
     * @return A string indicating the next view. If there are errors, it returns to the update view.
     *         If the bid list is successfully updated, it redirects to the list view.
     */
    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating, BindingResult result, Model model) {
        logger.info("Updating Rating with id: " + id);
        if(result.hasErrors()) {
            model.addAttribute("rating", rating);
            logger.error("Error updating Rating with id: " + id);
            return "rating/update";
        }
        ratingService.updateRating(rating);
        logger.info("Updated Rating with id: " + id);
        return "redirect:/rating/list";
    }

    /**
     * Handles the POST request to delete a rating by id.
     *
     * @param id    The id of the rating to be deleted.
     * @param model The Model object to be used in the view.
     * @return A String that represents the list of rating to be returned.
     */
    @PostMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        logger.info("Deleting Rating with id: " + id);
        ratingService.deleteRatingById(id);
        logger.info("Deleted Rating with id: " + id);
        return "redirect:/rating/list";
    }
    
}