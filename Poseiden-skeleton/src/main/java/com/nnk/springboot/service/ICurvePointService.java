package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;
import java.util.Optional;

public interface ICurvePointService {

    /**
     * Retrieves all curvePoints from the repository.
     * @return A list containing all curvePoints.
     */
    public List<CurvePoint> getCurvePoints();

    /**
     * Retrieves a curvePoint by its ID.
     * @param curvePointId The ID of the curvePoint to retrieve.
     * @return An Optional containing the curvePoint, or an empty Optional if not found.
     */
    public Optional<CurvePoint> getCurvePointById(int curvePointId);

    /**
     * Adds a new curvePoint to the repository.
     * @param curvePoint The CurvePoint object to be added.
     * @return The added CurvePoint object.
     */
    public CurvePoint addCurvePoint(CurvePoint curvePoint);

    /**
     * Updates a curvePoint in the repository.
     * @param curvePoint The curvePoint object to be updated.
     * @return The updated curvePoint object.
     */
    public CurvePoint updateCurvePoint(CurvePoint curvePoint);

    /**
     * Deletes a curvePoint by their ID.
     * @param curvePointId The ID of the curvePoint to be deleted.
     */
    public void deleteCurvePointById(int curvePointId);

}