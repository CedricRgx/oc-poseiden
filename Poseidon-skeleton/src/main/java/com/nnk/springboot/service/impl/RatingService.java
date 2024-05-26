package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.IRatingService;
import jakarta.persistence.EntityNotFoundException;
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

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

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
        verifyRatingExistence(ratingId);
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
        verifyRatingExistence(rating.getId());
        return ratingRepository.save(rating);
    }

    /**
     * Deletes a rating by its ID.
     * @param ratingId The ID of the rating to be deleted.
     */
    @Transactional
    public void deleteRatingById(int ratingId){
        logger.info("Deleting a rating");
        verifyRatingExistence(ratingId);
        ratingRepository.deleteById(ratingId);
    }

    /**
     * This method checks if a Rating with a given ID exists in the repository.
     *
     * @param id An integer representing the ID of the Rating.
     * @throws EntityNotFoundException if no Rating with the provided ID is found in the repository.
     */
    private void verifyRatingExistence(int id){
        if(!ratingRepository.existsById(id)){
            throw new PoseidonEntityNotFoundException("Rating is not found ", id);
        }
    }

}
