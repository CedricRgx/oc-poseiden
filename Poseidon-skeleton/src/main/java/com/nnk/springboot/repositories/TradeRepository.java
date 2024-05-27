package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Trade entities.
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
