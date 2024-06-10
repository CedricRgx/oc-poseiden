package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.impl.BidListService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling bidList in the Poseidon application
 */
@Controller
public class BidListController {

    private static final Logger logger = LoggerFactory.getLogger(BidListController.class);

    private final BidListService bidListService;

    @Autowired
    public BidListController(BidListService bidListService) {
        this.bidListService = bidListService;
    }

    /**
     * Displays the list of bidLists.
     *
     * @param model The model for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of bidLists.
     */
/*    @GetMapping("/bidList/list")
    public String home(Model model){
        logger.info("Loading Bid List list page");
        List<BidList> bidLists = bidListService.getBidLists();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(bidLists == null) {
            logger.error("Error retrieving bidLists for list page");
        } else {
            logger.info("Successfully retrieved bidLists for list page");
            model.addAttribute("bidLists", bidLists);
            model.addAttribute("user", userDetails);
        }
        return "bidList/list";
    }*/
    @GetMapping("/bidList/list")
    public String home(Model model) {
        logger.info("Loading Bid List list page");
        List<BidList> bidLists = bidListService.getBidLists();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (bidLists == null) {
            logger.error("Error retrieving bidLists for list page");
        } else {
            logger.info("Successfully retrieved bidLists for list page");
            model.addAttribute("bidLists", bidLists);

            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                model.addAttribute("user", userDetails);
            } else if (principal instanceof DefaultOAuth2User) {
                DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
                model.addAttribute("user", oauth2User.getAttributes());
            }
        }

        return "bidList/list";
    }

    /**
     * Displays the view to add a bidList.
     *
     * @param bid The bid to add for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of bidLists.
     */
    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        logger.info("Loading add bid form");
        return "bidList/add";
    }

    /**
     * Handles the POST request to validate and save a bid list.
     *
     * @param bidList The bid list to be validated and saved.
     * @param result The binding result which holds the validation results for the bid list.
     * @param model The Model object to be used in the view.
     * @return A String indicating the next view. If there are errors, it returns to the add view.
     *         If the bid list is successfully saved, it redirects to the bid list view.
     */
    @PostMapping("/bidList/validate")
    public String validate(@Valid @ModelAttribute("bidList") BidList bidList, BindingResult result, Model model) {
        logger.info("Bid List validation started");
        if(result.hasErrors()) {
            model.addAttribute("bidList", bidList);
            logger.error("Bid List validation has errors");
            return "bidList/add";
        }
        bidListService.addBidList(bidList);
        logger.info("Bid List validation finished successfully, Bid List added");
        return "redirect:/bidList/list";
    }

    /**
     * Handles the GET request to display the form for updating a bid list.
     *
     * @param id The id of the bid list to be updated.
     * @param model The Model object to be used in the view.
     * @return A String that represents the view to be returned.
     *         This is the update view for the bid list.
     */
    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("Show update form for Bid List with id: " + id);
        Optional<BidList> bid = bidListService.getBidListById(id);
        if(bid.isPresent()) {
            model.addAttribute("bidList", bid.get());
        }else{
            logger.warn("Bid List with id: " + id + " not found");
        }
        return "bidList/update";
    }

    /**
     * Handles the POST request to update a bid list.
     *
     * @param id The id of the bid list to be updated.
     * @param bidList The updated bid list.
     * @param result The binding result which holds the validation results for the bid list.
     * @param model The Model object to be used in the view.
     * @return A string indicating the next view. If there are errors, it returns to the update view.
     *         If the bid list is successfully updated, it redirects to the list view.
     */
    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList, BindingResult result, Model model) {
        logger.info("Updating Bid List with id: " + id);
        if(result.hasErrors()) {
            model.addAttribute("bidList", bidList);
            logger.error("Error updating Bid List with id: " + id);
            return "bidList/update";
        }
        bidListService.updateBidList(bidList);
        logger.info("Updated Bid List with id: " + id);
        return "redirect:/bidList/list";
    }

    /**
     * Handles the POST request to delete a bid list by id.
     *
     * @param id    The id of the bid list to be deleted.
     * @param model The Model object to be used in the view.
     * @return A String that represents the list of bid to be returned.
     */
    @PostMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        logger.info("Deleting Bid List with id: " + id);
        bidListService.deleteBidListById(id);
        logger.info("Deleted Bid List with id: " + id);
        return "redirect:/bidList/list";
    }

}