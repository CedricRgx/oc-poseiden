package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.IRatingService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The RatingService class provides business logic related to Rating entities.
 */
@Service
public class RatingService implements IRatingService {

    private static final Logger logger = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    private RatingRepository ratingRepository;

    /**
     * Retrieves all ratings from the repository.
     * @return A list containing all ratings.
     */
    public List<Rating> getRatings(){
        logger.info("Retrieving the list of ratings");
        return ratingRepository.findAll();
    }

    /**
     * Retrieves a rating by its ID.
     * @param ratingId The ID of the rating to retrieve.
     * @return An Optional containing the rating, or an empty Optional if not found.
     */
    public Optional<Rating> getRatingById(int ratingId){
        logger.info("Retrieving a rating by its id");
        return ratingRepository.findById(ratingId);
    }

    /**
     * Adds a new rating to the repository.
     * @param rating The Rating object to be added.
     * @return The added Rating object.
     */
    @Transactional
    public Rating addRating(Rating rating){
        logger.info("Adding a rating");
        return ratingRepository.save(rating);
    }

    /**
     * Updates a rating in the repository.
     * @param rating The Rating object to be updated.
     * @return The updated Rating object.
     */
    @Transactional
    public Rating updateRating(Rating rating){
        logger.info("Updating a rating");
        return ratingRepository.save(rating);
    }

    /**
     * Deletes a rating by its ID.
     * @param ratingId The ID of the rating to be deleted.
     */
    @Transactional
    public void deleteRatingById(int ratingId){
        logger.info("Deleting a rating");
        ratingRepository.deleteById(ratingId);
    }

}
