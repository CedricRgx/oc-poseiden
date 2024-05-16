package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the BidList entities.
 */
@Repository
public interface BidListRepository extends JpaRepository<BidList, Integer> {

}
