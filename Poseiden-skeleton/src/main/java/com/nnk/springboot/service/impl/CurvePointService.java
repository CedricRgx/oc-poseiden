package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.service.ICurvePointService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The CurvePointService class provides business logic related to CurvePoint entities.
 */
@Service
public class CurvePointService implements ICurvePointService {

    private static final Logger logger = LoggerFactory.getLogger(CurvePointService.class);

    @Autowired
    private CurvePointRepository curvePointRepository;

    /**
     * Retrieves all curvePoints from the repository.
     * @return A list containing all curvePoints.
     */
    public List<CurvePoint> getCurvePoints(){
        logger.info("Retrieving the list of curvePoints");
        return curvePointRepository.findAll();
    }

    /**
     * Retrieves a curvePoint by its ID.
     * @param curvePointId The ID of the curvePoint to retrieve.
     * @return An Optional containing the curvePoint, or an empty Optional if not found.
     */
    public Optional<CurvePoint> getCurvePointById(int curvePointId){
        logger.info("Retrieving a curvePoint by its id");
        return curvePointRepository.findById(curvePointId);
    }

    /**
     * Adds a new curvePoint to the repository.
     * @param curvePoint The CurvePoint object to be added.
     * @return The added CurvePoint object.
     */
    @Transactional
    public CurvePoint addCurvePoint(CurvePoint curvePoint){
        logger.info("Adding a curvePoint");
        return curvePointRepository.save(curvePoint);
    }

    /**
     * Updates a curvePoint in the repository.
     * @param curvePoint The CurvePoint object to be updated.
     * @return The updated CurvePoint object.
     */
    @Transactional
    public CurvePoint updateCurvePoint(CurvePoint curvePoint){
        logger.info("Updating a curvePoint");
        return curvePointRepository.save(curvePoint);
    }

    /**
     * Deletes a curvePoint by its ID.
     * @param curvePointId The ID of the curvePoint to be deleted.
     */
    @Transactional
    public void deleteCurvePointById(int curvePointId){
        logger.info("Deleting a curvePoint");
        curvePointRepository.deleteById(curvePointId);
    }

}