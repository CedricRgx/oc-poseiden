package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Trade entities.
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

    List<Trade> findAll();

    Optional<Trade> findById(Integer tradeId);

    Trade save(Trade trade);

    void deleteById(Integer tradeId);

}
