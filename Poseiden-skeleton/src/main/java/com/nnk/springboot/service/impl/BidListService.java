package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.exceptions.PoseidenEntityNotFoundException;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.IBidListService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The BidListService class provides business logic related to BidList entities.
 */
@Service
public class BidListService implements IBidListService {

    private static final Logger logger = LoggerFactory.getLogger(BidListService.class);

    private final BidListRepository bidListRepository;

    @Autowired
    public BidListService(BidListRepository bidListRepository) {
        this.bidListRepository = bidListRepository;
    }

    /**
     * Retrieves all bidLists from the repository.
     *
     * @return A list containing all bidLists.
     */
    public List<BidList> getBidLists(){
        logger.info("Retrieving the list of bidLists");
        return bidListRepository.findAll();
    }

    /**
     * Retrieves a bidList by its ID.
     *
     * @param bidListId The ID of the bidList to retrieve.
     *
     * @return An Optional containing the bidList, or an empty Optional if not found.
     */
    public Optional<BidList> getBidListById(int bidListId){
        logger.info("Retrieving a bidList by its id");
        verifyBidListExistence(bidListId);
        return bidListRepository.findById(bidListId);
    }

    /**
     * Adds a new bidList to the repository.
     *
     * @param bidList The BidList object to be added.
     *
     * @return The added BidList object.
     */
    @Transactional
    public BidList addBidList(BidList bidList){
        logger.info("Adding a bidList");
        return bidListRepository.save(bidList);
    }

    /**
     * Updates a bidList in the repository.
     *
     * @param bidList The BidList object to be updated.
     *
     * @return The updated BidList object.
     */
    @Transactional
    public BidList updateBidList(BidList bidList){
        logger.info("Updating a bidList");
        verifyBidListExistence(bidList.getId());
        return bidListRepository.save(bidList);
    }

    /**
     * Deletes a bidList by its ID.
     *
     * @param bidListId The ID of the bidList to be deleted.
     */
    @Transactional
    public void deleteBidListById(int bidListId){
        logger.info("Deleting a bidList");
        verifyBidListExistence(bidListId);
        bidListRepository.deleteById(bidListId);
    }

    /**
     * This method checks if a BidList with a given ID exists in the repository.
     *
     * @param id An integer representing the ID of the BidList.
     * @throws EntityNotFoundException if no BidList with the provided ID is found in the repository.
     */
    private void verifyBidListExistence(int id){
        if(!bidListRepository.existsById(id)){
            throw new PoseidenEntityNotFoundException("BidList is not found ", id);
        }
    }

}