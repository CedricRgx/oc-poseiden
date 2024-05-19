package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.ITradeService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The TradeService class provides business logic related to Trade entities.
 */
@Service
public class TradeService implements ITradeService {

    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    @Autowired
    private TradeRepository tradeRepository;

    /**
     * Retrieves all tradeServices from the repository.
     * @return A list containing all tradeServices.
     */
    public List<Trade> getTrades(){
        logger.info("Retrieving the list of trades");
        return tradeRepository.findAll();
    }

    /**
     * Retrieves a trade by its ID.
     * @param tradeId The ID of the trade to retrieve.
     * @return An Optional containing the trade, or an empty Optional if not found.
     */
    public Optional<Trade> getTradeById(int tradeId){
        logger.info("Retrieving a trade by its id");
        return tradeRepository.findById(tradeId);
    }

    /**
     * Adds a new trade to the repository.
     * @param trade The Trade object to be added.
     * @return The added Trade object.
     */
    @Transactional
    public Trade addTrade(Trade trade){
        logger.info("Adding a trade");
        return tradeRepository.save(trade);
    }

    /**
     * Updates a trade in the repository.
     * @param trade The Trade object to be updated.
     * @return The updated Trade object.
     */
    @Transactional
    public Trade updateTrade(Trade trade){
        logger.info("Updating a Trade");
        return tradeRepository.save(trade);
    }

    /**
     * Deletes a trade by its ID.
     * @param tradeId The ID of the trade to be deleted.
     */
    @Transactional
    public void deleteTradeById(int tradeId){
        logger.info("Deleting a trade");
        tradeRepository.deleteById(tradeId);
    }

}
