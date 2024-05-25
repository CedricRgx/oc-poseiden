package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.impl.CurvePointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
public class CurvePointController {
    
    private static final Logger logger = LoggerFactory.getLogger(CurvePointController.class);

    @Autowired
    private CurvePointService curvePointService;

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        // TODO: find all Curve Point, add to model
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
        return "redirect:/curvePoint/list";
    }


   /* *//**
     * This method responds to a GET request at the "/curvePoint/list" URL.
     *
     * @return ResponseEntity<List<CurvePoint>> If the curvePoint list is not empty, it returns a response entity with the list of curvePoints and HTTP status code 200 (OK).
     * If the curvePoint list is empty, it returns a response entity with an empty list and HTTP status code 404 (NOT FOUND).
     **//*
    @GetMapping("/curvePoint/list")
    public ResponseEntity<List<CurvePoint>> getAllCurvePoints() {
        logger.info("GET request on the endpoint /curvePoint/list: getting the list of curvePoints");
        List<CurvePoint> curvePointList = curvePointService.getCurvePoints();
        HttpStatus status;
        if (curvePointList.isEmpty()) {
            logger.error("No curvePoints found in the database");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Successfully getting the list of all curvePoints");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(curvePointList, status);
    }

    *//**
     * This method responds to a GET request at the "/curvePoint/id" URL.
     *
     * @return ResponseEntity<CurvePoint> If the curvePoint is not empty, it returns a response entity with the curvePoint and HTTP status code 200 (OK).
     * If the curvePoint is empty, it returns a response entity with a HTTP status code 404 (NOT FOUND).
     **//*
    @GetMapping("/curvePoint/{id}")
    public ResponseEntity<CurvePoint> getCurvePointById(@PathVariable("id") Integer curvePointId) {
        logger.info("GET request on the endpoint /curvePoint/id: getting the curvePoint by its id");
        Optional<CurvePoint> curvePoint = curvePointService.getCurvePointById(curvePointId);
        if (curvePoint.isEmpty()) {
            logger.error("No curvePoint found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successfully getting the curvePoint by its ID");
            return new ResponseEntity<>(curvePoint.get(), HttpStatus.OK);
        }
    }

    *//**
     * This method responds to a POST request at the "/curvePoint/add" URL.
     *
     * @return ResponseEntity<CurvePoint> If the curvePoint has been added, it returns a response entity with the curvePoint and HTTP status CREATED.
     * If the curvePoint has not been added, it returns a response entity with a HTTP status code BAD_REQUEST.
     **//*
    @PostMapping("/curvePoint/add")
    public ResponseEntity<CurvePoint> addNewCurvePoint(@RequestBody CurvePoint curvePoint) {
        logger.info("POST request on the endpoint /curvePoint/add: adding an curvePoint");
        CurvePoint curvePointAdded = curvePointService.addCurvePoint(curvePoint);
        HttpStatus status;
        if (curvePointAdded == null) {
            logger.error("Error adding curvePoint");
            status = HttpStatus.BAD_REQUEST;
        }else{
            logger.info("Success adding curvePoint");
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(curvePointAdded, status);
    }

    *//**
     * This method responds to a PUT request at the "/curvePoint/update/{id}" URL.
     *
     * @return ResponseEntity<CurvePoint> If the curvePoint has been updated, it returns a response entity with the curvePoint and HTTP status OK.
     * If the curvePoint has not been updated, it returns a response entity with a HTTP status code NOT_FOUND.
     **//*
    @PutMapping("/curvePoint/update/{id}")
    public ResponseEntity<CurvePoint> updateCurvePoint(@PathVariable("id") Integer curvePointId, @RequestBody CurvePoint curvePoint) {
        logger.info("PUT request on the endpoint /curvePoint/update/{id}: updating an curvePoint");
        curvePoint.setCurvePointId(curvePointId);
        CurvePoint curvePointUpdated = curvePointService.updateCurvePoint(curvePoint);
        HttpStatus status;
        if (curvePointUpdated == null) {
            logger.error("Error updating curvePoint");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Success updating curvePoint");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(curvePointUpdated, status);
    }

    *//**
     * This method responds to a DELETE request at the "/curvePoint/delete/{id}" URL.
     *
     * @return ResponseEntity<Void> If the curvePoint has been deleted, it returns a response entity with HTTP status NO_CONTENT.
     * If the curvePoint is not found, it returns a response entity with HTTP status code NOT_FOUND.
     **//*
    @DeleteMapping("/curvePoint/delete/{id}")
    public ResponseEntity<Void> deleteCurvePoint(@PathVariable("id") Integer curvePointId) {
        logger.info("DELETE request on the endpoint /curvePoint/delete/{id}: deleting an curvePoint");
        Optional<CurvePoint> curvePoint = curvePointService.getCurvePointById(curvePointId);
        HttpStatus status;
        if (curvePoint.isEmpty()) {
            logger.error("Error deleting user: curvePoint not found");
            status = HttpStatus.NOT_FOUND;
        }else{
            curvePointService.deleteCurvePointById(curvePointId);
            logger.info("Success deleting curvePoint");
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(status);
    }*/
}
