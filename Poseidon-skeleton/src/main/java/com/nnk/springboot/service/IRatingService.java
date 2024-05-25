package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;

import java.util.List;
import java.util.Optional;

public interface IRatingService {

    /**
     * Retrieves all ratings from the repository.
     * @return A list containing all ratings.
     */
    public List<Rating> getRatings();

    /**
     * Retrieves a rating by its ID.
     * @param ratingId The ID of the rating to retrieve.
     * @return An Optional containing the rating, or an empty Optional if not found.
     */
    public Optional<Rating> getRatingById(int ratingId);

    /**
     * Adds a new rating to the repository.
     * @param rating The Rating object to be added.
     * @return The added Rating object.
     */
    public Rating addRating(Rating rating);

    /**
     * Updates a rating in the repository.
     * @param rating The rating object to be updated.
     * @return The updated rating object.
     */
    public Rating updateRating(Rating rating);

    /**
     * Deletes a rating by their ID.
     * @param ratingId The ID of the rating to be deleted.
     */
    public void deleteRatingById(int ratingId);

}