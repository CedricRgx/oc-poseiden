package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.impl.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
public class RatingController {
    
    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    private RatingService ratingService;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        // TODO: find all Rating, add to model
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
        return "redirect:/rating/list";
    }


   /* *//**
     * This method responds to a GET request at the "/rating/list" URL.
     *
     * @return ResponseEntity<List<Rating>> If the rating list is not empty, it returns a response entity with the list of ratings and HTTP status code 200 (OK).
     * If the rating list is empty, it returns a response entity with an empty list and HTTP status code 404 (NOT FOUND).
     **//*
    @GetMapping("/rating/list")
    public ResponseEntity<List<Rating>> getAllRatings() {
        logger.info("GET request on the endpoint /rating/list: getting the list of ratings");
        List<Rating> ratingList = ratingService.getRatings();
        HttpStatus status;
        if (ratingList.isEmpty()) {
            logger.error("No ratings found in the database");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Successfully getting the list of all ratings");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(ratingList, status);
    }

    *//**
     * This method responds to a GET request at the "/rating/id" URL.
     *
     * @return ResponseEntity<Rating> If the rating is not empty, it returns a response entity with the rating and HTTP status code 200 (OK).
     * If the rating is empty, it returns a response entity with a HTTP status code 404 (NOT FOUND).
     **//*
    @GetMapping("/rating/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("id") Integer ratingId) {
        logger.info("GET request on the endpoint /rating/id: getting the rating by its id");
        Optional<Rating> rating = ratingService.getRatingById(ratingId);
        if (rating.isEmpty()) {
            logger.error("No rating found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successfully getting the rating by its ID");
            return new ResponseEntity<>(rating.get(), HttpStatus.OK);
        }
    }

    *//**
     * This method responds to a POST request at the "/rating/add" URL.
     *
     * @return ResponseEntity<Rating> If the rating has been added, it returns a response entity with the rating and HTTP status CREATED.
     * If the rating has not been added, it returns a response entity with a HTTP status code BAD_REQUEST.
     **//*
    @PostMapping("/rating/add")
    public ResponseEntity<Rating> addNewRating(@RequestBody Rating rating) {
        logger.info("POST request on the endpoint /rating/add: adding an rating");
        Rating ratingAdded = ratingService.addRating(rating);
        HttpStatus status;
        if (ratingAdded == null) {
            logger.error("Error adding rating");
            status = HttpStatus.BAD_REQUEST;
        }else{
            logger.info("Success adding rating");
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(ratingAdded, status);
    }

    *//**
     * This method responds to a PUT request at the "/rating/update/{id}" URL.
     *
     * @return ResponseEntity<Rating> If the rating has been updated, it returns a response entity with the rating and HTTP status OK.
     * If the rating has not been updated, it returns a response entity with a HTTP status code NOT_FOUND.
     **//*
    @PutMapping("/rating/update/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable("id") Integer ratingId, @RequestBody Rating rating) {
        logger.info("PUT request on the endpoint /rating/update/{id}: updating an rating");
        rating.setRatingId(ratingId);
        Rating ratingUpdated = ratingService.updateRating(rating);
        HttpStatus status;
        if (ratingUpdated == null) {
            logger.error("Error updating rating");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Success updating rating");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(ratingUpdated, status);
    }

    *//**
     * This method responds to a DELETE request at the "/rating/delete/{id}" URL.
     *
     * @return ResponseEntity<Void> If the rating has been deleted, it returns a response entity with HTTP status NO_CONTENT.
     * If the rating is not found, it returns a response entity with HTTP status code NOT_FOUND.
     **//*
    @DeleteMapping("/rating/delete/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable("id") Integer ratingId) {
        logger.info("DELETE request on the endpoint /rating/delete/{id}: deleting an rating");
        Optional<Rating> rating = ratingService.getRatingById(ratingId);
        HttpStatus status;
        if (rating.isEmpty()) {
            logger.error("Error deleting user: rating not found");
            status = HttpStatus.NOT_FOUND;
        }else{
            ratingService.deleteRatingById(ratingId);
            logger.info("Success deleting rating");
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(status);
    }*/
}
