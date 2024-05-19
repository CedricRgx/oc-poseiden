package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the CurvePoint entities.
 */
@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

    List<CurvePoint> findAll();

    Optional<CurvePoint> findById(Integer curvePointId);

    CurvePoint save(CurvePoint curvePoint);

    void deleteById(Integer curvePointId);

}
