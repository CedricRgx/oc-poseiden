package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the CurvePoint entities.
 */
@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {
}
