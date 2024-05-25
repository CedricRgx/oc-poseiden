package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;

import java.util.List;
import java.util.Optional;

public interface ITradeService {

    /**
     * Retrieves all trades from the repository.
     * @return A list containing all trades.
     */
    public List<Trade> getTrades();

    /**
     * Retrieves a trade by its ID.
     * @param tradeId The ID of the trade to retrieve.
     * @return An Optional containing the trade, or an empty Optional if not found.
     */
    public Optional<Trade> getTradeById(int tradeId);

    /**
     * Adds a new trade to the repository.
     * @param trade The Trade object to be added.
     * @return The added Trade object.
     */
    public Trade addTrade(Trade trade);

    /**
     * Updates a trade in the repository.
     * @param trade The Trade object to be updated.
     * @return The updated Trade object.
     */
    public Trade updateTrade(Trade trade);

    /**
     * Deletes a trade by their ID.
     * @param tradeId The ID of the trade to be deleted.
     */
    public void deleteTradeById(int tradeId);

}