package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.impl.TradeService;
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
public class TradeController {
    
    private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

    @Autowired
    private TradeService tradeService;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
        return "redirect:/trade/list";
    }

    /**
     * This method responds to a GET request at the "/trade/list" URL.
     *
     * @return ResponseEntity<List<Trade>> If the trade list is not empty, it returns a response entity with the list of trades and HTTP status code 200 (OK).
     * If the trade list is empty, it returns a response entity with an empty list and HTTP status code 404 (NOT FOUND).
     **//*
    @GetMapping("/trade/list")
    public ResponseEntity<List<Trade>> getAllTrades() {
        logger.info("GET request on the endpoint /trade/list: getting the list of trades");
        List<Trade> tradeList = tradeService.getTrades();
        HttpStatus status;
        if (tradeList.isEmpty()) {
            logger.error("No trades found in the database");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Successfully getting the list of all trades");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(tradeList, status);
    }

    *//**
     * This method responds to a GET request at the "/trade/id" URL.
     *
     * @return ResponseEntity<Trade> If the trade is not empty, it returns a response entity with the trade and HTTP status code 200 (OK).
     * If the trade is empty, it returns a response entity with a HTTP status code 404 (NOT FOUND).
     **//*
    @GetMapping("/trade/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable("id") Integer tradeId) {
        logger.info("GET request on the endpoint /trade/id: getting the trade by its id");
        Optional<Trade> trade = tradeService.getTradeById(tradeId);
        if (trade.isEmpty()) {
            logger.error("No trade found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successfully getting the trade by its ID");
            return new ResponseEntity<>(trade.get(), HttpStatus.OK);
        }
    }

    *//**
     * This method responds to a POST request at the "/trade/add" URL.
     *
     * @return ResponseEntity<Trade> If the trade has been added, it returns a response entity with the trade and HTTP status CREATED.
     * If the trade has not been added, it returns a response entity with a HTTP status code BAD_REQUEST.
     **//*
    @PostMapping("/trade/add")
    public ResponseEntity<Trade> addNewTrade(@RequestBody Trade trade) {
        logger.info("POST request on the endpoint /trade/add: adding an trade");
        Trade tradeAdded = tradeService.addTrade(trade);
        HttpStatus status;
        if (tradeAdded == null) {
            logger.error("Error adding trade");
            status = HttpStatus.BAD_REQUEST;
        }else{
            logger.info("Success adding trade");
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(tradeAdded, status);
    }

    *//**
     * This method responds to a PUT request at the "/trade/update/{id}" URL.
     *
     * @return ResponseEntity<Trade> If the trade has been updated, it returns a response entity with the trade and HTTP status OK.
     * If the trade has not been updated, it returns a response entity with a HTTP status code NOT_FOUND.
     **//*
    @PutMapping("/trade/update/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable("id") Integer tradeId, @RequestBody Trade trade) {
        logger.info("PUT request on the endpoint /trade/update/{id}: updating an trade");
        trade.setTradeId(tradeId);
        Trade tradeUpdated = tradeService.updateTrade(trade);
        HttpStatus status;
        if (tradeUpdated == null) {
            logger.error("Error updating trade");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Success updating trade");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(tradeUpdated, status);
    }

    *//**
     * This method responds to a DELETE request at the "/trade/delete/{id}" URL.
     *
     * @return ResponseEntity<Void> If the trade has been deleted, it returns a response entity with HTTP status NO_CONTENT.
     * If the trade is not found, it returns a response entity with HTTP status code NOT_FOUND.
     **//*
    @DeleteMapping("/trade/delete/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable("id") Integer tradeId) {
        logger.info("DELETE request on the endpoint /trade/delete/{id}: deleting an trade");
        Optional<Trade> trade = tradeService.getTradeById(tradeId);
        HttpStatus status;
        if (trade.isEmpty()) {
            logger.error("Error deleting user: trade not found");
            status = HttpStatus.NOT_FOUND;
        }else{
            tradeService.deleteTradeById(tradeId);
            logger.info("Success deleting trade");
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(status);
    }*/
}
