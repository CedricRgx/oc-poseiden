package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.impl.RuleNameService;
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

@Controller
public class RuleNameController {

    private static final Logger logger = LoggerFactory.getLogger(RuleNameController.class);

    private final RuleNameService ruleNameService;

    @Autowired
    public RuleNameController(RuleNameService ruleNameService) {
        this.ruleNameService = ruleNameService;
    }

    /**
     * Displays the list of ruleNames.
     *
     * @param model The model for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of ruleNames.
     */
    @GetMapping("/ruleName/list")
    public String home(Model model){
        logger.info("Loading ruleName list page");
        List<RuleName> ruleNames = ruleNameService.getRuleNames();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(ruleNames == null) {
            logger.error("Error retrieving ruleNames for list page");
        } else {
            logger.info("Successfully retrieved ruleNames for list page");
            model.addAttribute("ruleNames", ruleNames);
            model.addAttribute("user", userDetails);
        }
        return "ruleName/list";
    }

    /**
     * Displays the view to add a ruleName.
     *
     * @param ruleName The ruleName to add for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of ruleNames.
     */
    @GetMapping("/ruleName/add")
    public String addRuleNameForm(RuleName ruleName) {
        logger.info("Loading add ruleName form");
        return "ruleName/add";
    }

    /**
     * Handles the POST request to validate and save a ruleName.
     *
     * @param ruleName The ruleName to be validated and saved.
     * @param result The binding result which holds the validation results for the ruleName.
     * @param model The Model object to be used in the view.
     * @return A String indicating the next view. If there are errors, it returns to the add view.
     *         If the ruleName is successfully saved, it redirects to the ruleName view.
     */
    @PostMapping("/ruleName/validate")
    public String validate(@Valid @ModelAttribute("ruleName") RuleName ruleName, BindingResult result, Model model) {
        logger.info("RuleName validation started");
        if(result.hasErrors()) {
            model.addAttribute("ruleName", ruleName);
            logger.error("RuleName validation has errors");
            return "ruleName/add";
        }
        ruleNameService.addRuleName(ruleName);
        logger.info("RuleName validation finished successfully, RuleName added");
        return "redirect:/ruleName/list";
    }


    /**
     * Handles the GET request to display the form for updating a ruleName.
     *
     * @param id The id of the ruleName to be updated.
     * @param model The Model object to be used in the view.
     * @return A String that represents the view to be returned.
     *         This is the update view for the ruleName.
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("Show update form for RuleName with id: " + id);
        Optional<RuleName> bid = ruleNameService.getRuleNameById(id);
        if(bid.isPresent()) {
            model.addAttribute("ruleName", bid.get());
        }else{
            logger.warn("RuleName with id: " + id + " not found");
        }
        return "ruleName/update";
    }

    /**
     * Handles the POST request to update a ruleName.
     *
     * @param id The id of the ruleName to be updated.
     * @param ruleName The updated ruleName.
     * @param result The binding result which holds the validation results for the ruleName.
     * @param model The Model object to be used in the view.
     * @return A string indicating the next view. If there are errors, it returns to the update view.
     *         If the bid list is successfully updated, it redirects to the list view.
     */
    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName, BindingResult result, Model model) {
        logger.info("Updating RuleName with id: " + id);
        if(result.hasErrors()) {
            model.addAttribute("ruleName", ruleName);
            logger.error("Error updating RuleName with id: " + id);
            return "ruleName/update";
        }
        ruleNameService.updateRuleName(ruleName);
        logger.info("Updated RuleName with id: " + id);
        return "redirect:/ruleName/list";
    }

    /**
     * Handles the POST request to delete a ruleName by id.
     *
     * @param id    The id of the ruleName to be deleted.
     * @param model The Model object to be used in the view.
     * @return A String that represents the list of ruleName to be returned.
     */
    @PostMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        logger.info("Deleting RuleName with id: " + id);
        ruleNameService.deleteRuleNameById(id);
        logger.info("Deleted RuleName with id: " + id);
        return "redirect:/ruleName/list";
    }
    
}