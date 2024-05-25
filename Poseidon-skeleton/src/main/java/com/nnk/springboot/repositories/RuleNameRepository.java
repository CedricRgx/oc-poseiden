package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the RuleName entities.
 */
@Repository
public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {
}
