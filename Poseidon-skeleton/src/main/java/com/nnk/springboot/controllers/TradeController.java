package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.service.impl.TradeService;
import com.nnk.springboot.service.impl.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling trade in the Poseidon application
 */
@Controller
public class TradeController {
    
    private static final Logger logger = LoggerFactory.getLogger(TradeController.class);

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    /**
     * Displays the list of trades.
     *
     * @param model The model for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of trades.
     */
    @GetMapping("/trade/list")
    public String home(Model model){
        logger.info("Loading trade list page");
        List<Trade> trades = tradeService.getTrades();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(trades == null) {
            logger.error("Error retrieving trades for list page");
        } else {
            logger.info("Successfully retrieved trades for list page");
            model.addAttribute("trades", trades);
            model.addAttribute("user", userDetails);
        }
        return "trade/list";
    }

    /**
     * Displays the view to add a trade.
     *
     * @param trade The trade to add for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of trades.
     */
    @GetMapping("/trade/add")
    public String addTradeForm(Trade trade) {
        logger.info("Loading add trade form");
        return "trade/add";
    }

    /**
     * Handles the POST request to validate and save a trade.
     *
     * @param trade The trade to be validated and saved.
     * @param result The binding result which holds the validation results for the trade.
     * @param model The Model object to be used in the view.
     * @return A String indicating the next view. If there are errors, it returns to the add view.
     *         If the trade is successfully saved, it redirects to the trade view.
     */
    @PostMapping("/trade/validate")
    public String validate(@Valid @ModelAttribute("trade") Trade trade, BindingResult result, Model model) {
        logger.info("Trade validation started");
        if(result.hasErrors()) {
            model.addAttribute("trade", trade);
            logger.error("Trade validation has errors");
            return "trade/add";
        }
        tradeService.addTrade(trade);
        logger.info("Trade validation finished successfully, Trade added");
        return "redirect:/trade/list";
    }


    /**
     * Handles the GET request to display the form for updating a trade.
     *
     * @param id The id of the trade to be updated.
     * @param model The Model object to be used in the view.
     * @return A String that represents the view to be returned.
     *         This is the update view for the trade.
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("Show update form for Trade with id: " + id);
        Optional<Trade> bid = tradeService.getTradeById(id);
        if(bid.isPresent()) {
            model.addAttribute("trade", bid.get());
        }else{
            logger.warn("Trade with id: " + id + " not found");
        }
        return "trade/update";
    }

    /**
     * Handles the POST request to update a trade.
     *
     * @param id The id of the trade to be updated.
     * @param trade The updated trade.
     * @param result The binding result which holds the validation results for the trade.
     * @param model The Model object to be used in the view.
     * @return A string indicating the next view. If there are errors, it returns to the update view.
     *         If the bid list is successfully updated, it redirects to the list view.
     */
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade, BindingResult result, Model model) {
        logger.info("Updating Trade with id: " + id);
        if(result.hasErrors()) {
            model.addAttribute("trade", trade);
            logger.error("Error updating Trade with id: " + id);
            return "trade/update";
        }
        tradeService.updateTrade(trade);
        logger.info("Updated Trade with id: " + id);
        return "redirect:/trade/list";
    }

    /**
     * Handles the POST request to delete a trade by id.
     *
     * @param id    The id of the trade to be deleted.
     * @param model The Model object to be used in the view.
     * @return A String that represents the list of trade to be returned.
     */
    @PostMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        logger.info("Deleting Trade with id: " + id);
        tradeService.deleteTradeById(id);
        logger.info("Deleted Trade with id: " + id);
        return "redirect:/trade/list";
    }
    
}
