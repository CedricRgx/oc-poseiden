package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.impl.BidListService;
import com.nnk.springboot.service.impl.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BidListController {

    private static final Logger logger = LoggerFactory.getLogger(BidListController.class);

    @Autowired
    private BidListService bidListService;

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        // TODO: call service find all bids to show to the view
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return bid list
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Bid by Id and delete the bid, return to Bid list
        return "redirect:/bidList/list";
    }



    /**
     * This method responds to a GET request at the "/bidList/list" URL.
     *
     * @return ResponseEntity<List<BidList>> If the bidList list is not empty, it returns a response entity with the list of bidLists and HTTP status code 200 (OK).
     * If the bidList list is empty, it returns a response entity with an empty list and HTTP status code 404 (NOT FOUND).
     **/
    @GetMapping("/bidList/list")
    public ResponseEntity<List<BidList>> getAllBidLists() {
        logger.info("GET request on the endpoint /bidList/list: getting the list of bidLists");
        List<BidList> bidListList = bidListService.getBidLists();
        HttpStatus status;
        if (bidListList.isEmpty()) {
            logger.error("No bidLists found in the database");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Successfully getting the list of all bidLists");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(bidListList, status);
    }

    /**
     * This method responds to a GET request at the "/bidList/id" URL.
     *
     * @return ResponseEntity<BidList> If the bidList is not empty, it returns a response entity with the bidList and HTTP status code 200 (OK).
     * If the bidList is empty, it returns a response entity with a HTTP status code 404 (NOT FOUND).
     **/
    @GetMapping("/bidList/{id}")
    public ResponseEntity<BidList> getBidListById(@PathVariable("id") Integer bidListId) {
        logger.info("GET request on the endpoint /bidList/id: getting the bidList by its id");
        Optional<BidList> bidList = bidListService.getBidListById(bidListId);
        if (bidList.isEmpty()) {
            logger.error("No bidList found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successfully getting the bidList by its ID");
            return new ResponseEntity<>(bidList.get(), HttpStatus.OK);
        }
    }

    /**
     * This method responds to a POST request at the "/bidList/add" URL.
     *
     * @return ResponseEntity<BidList> If the bidList has been added, it returns a response entity with the bidList and HTTP status CREATED.
     * If the bidList has not been added, it returns a response entity with a HTTP status code BAD_REQUEST.
     **/
    @PostMapping("/bidList/add")
    public ResponseEntity<BidList> addNewBidList(@RequestBody BidList bidList) {
        logger.info("POST request on the endpoint /bidList/add: adding an bidList");
        BidList bidListAdded = bidListService.addBidList(bidList);
        HttpStatus status;
        if (bidListAdded == null) {
            logger.error("Error adding bidList");
            status = HttpStatus.BAD_REQUEST;
        }else{
            logger.info("Success adding bidList");
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(bidListAdded, status);
    }

    /**
     * This method responds to a PUT request at the "/bidList/update/{id}" URL.
     *
     * @return ResponseEntity<BidList> If the bidList has been updated, it returns a response entity with the bidList and HTTP status OK.
     * If the bidList has not been updated, it returns a response entity with a HTTP status code NOT_FOUND.
     **/
    @PutMapping("/bidList/update/{id}")
    public ResponseEntity<BidList> updateBidList(@PathVariable("id") Integer bidListId, @RequestBody BidList bidList) {
        logger.info("PUT request on the endpoint /bidList/update/{id}: updating an bidList");
        bidList.setBidListId(bidListId);
        BidList bidListUpdated = bidListService.updateBidList(bidList);
        HttpStatus status;
        if (bidListUpdated == null) {
            logger.error("Error updating bidList");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Success updating bidList");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(bidListUpdated, status);
    }

    /**
     * This method responds to a DELETE request at the "/bidList/delete/{id}" URL.
     *
     * @return ResponseEntity<Void> If the bidList has been deleted, it returns a response entity with HTTP status NO_CONTENT.
     * If the bidList is not found, it returns a response entity with HTTP status code NOT_FOUND.
     **/
    @DeleteMapping("/bidList/delete/{id}")
    public ResponseEntity<Void> deleteBidList(@PathVariable("id") Integer bidListId) {
        logger.info("DELETE request on the endpoint /bidList/delete/{id}: deleting an bidList");
        Optional<BidList> bidList = bidListService.getBidListById(bidListId);
        HttpStatus status;
        if (bidList.isEmpty()) {
            logger.error("Error deleting user: bidList not found");
            status = HttpStatus.NOT_FOUND;
        }else{
            bidListService.deleteBidListById(bidListId);
            logger.info("Success deleting bidList");
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(status);
    }
}
