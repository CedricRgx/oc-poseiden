package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;

import java.util.List;
import java.util.Optional;

public interface IBidListService {

    /**
     * Retrieves all bidLists from the repository.
     * @return A list containing all bidLists.
     */
    public List<BidList> getBidLists();

    /**
     * Retrieves a bidList by its ID.
     * @param bidListId The ID of the bidList to retrieve.
     * @return An Optional containing the bidList, or an empty Optional if not found.
     */
    public Optional<BidList> getBidListById(int bidListId);

    /**
     * Adds a new bidList to the repository.
     * @param bidList The BidList object to be added.
     * @return The added BidList object.
     */
    public BidList addBidList(BidList bidList);

    /**
     * Updates a bidList in the repository.
     * @param bidList The bidList object to be updated.
     * @return The updated bidList object.
     */
    public BidList updateBidList(BidList bidList);

    /**
     * Deletes a bidList by their ID.
     * @param bidListId The ID of the bidList to be deleted.
     */
    public void deleteBidListById(int bidListId);

}