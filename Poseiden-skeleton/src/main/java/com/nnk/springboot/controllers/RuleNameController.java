package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.service.impl.RuleNameService;
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
public class RuleNameController {

    private static final Logger logger = LoggerFactory.getLogger(RuleNameController.class);

    @Autowired
    private RuleNameService ruleNameService;

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
        return "redirect:/ruleName/list";
    }

    /**
     * This method responds to a GET request at the "/ruleName/list" URL.
     *
     * @return ResponseEntity<List<RuleName>> If the ruleName list is not empty, it returns a response entity with the list of ruleNames and HTTP status code 200 (OK).
     * If the ruleName list is empty, it returns a response entity with an empty list and HTTP status code 404 (NOT FOUND).
     **/
    @GetMapping("/ruleName/list")
    public ResponseEntity<List<RuleName>> getAllRuleNames() {
        logger.info("GET request on the endpoint /ruleName/list: getting the list of ruleNames");
        List<RuleName> ruleNameList = ruleNameService.getRuleNames();
        HttpStatus status;
        if (ruleNameList.isEmpty()) {
            logger.error("No ruleNames found in the database");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Successfully getting the list of all ruleNames");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(ruleNameList, status);
    }

    /**
     * This method responds to a GET request at the "/ruleName/id" URL.
     *
     * @return ResponseEntity<RuleName> If the ruleName is not empty, it returns a response entity with the ruleName and HTTP status code 200 (OK).
     * If the ruleName is empty, it returns a response entity with a HTTP status code 404 (NOT FOUND).
     **/
    @GetMapping("/ruleName/{id}")
    public ResponseEntity<RuleName> getRuleNameById(@PathVariable("id") Integer ruleNameId) {
        logger.info("GET request on the endpoint /ruleName/id: getting the ruleName by its id");
        Optional<RuleName> ruleName = ruleNameService.getRuleNameById(ruleNameId);
        if (ruleName.isEmpty()) {
            logger.error("No ruleName found in the database");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            logger.info("Successfully getting the ruleName by its ID");
            return new ResponseEntity<>(ruleName.get(), HttpStatus.OK);
        }
    }

    /**
     * This method responds to a POST request at the "/ruleName/add" URL.
     *
     * @return ResponseEntity<RuleName> If the ruleName has been added, it returns a response entity with the ruleName and HTTP status CREATED.
     * If the ruleName has not been added, it returns a response entity with a HTTP status code BAD_REQUEST.
     **/
    @PostMapping("/ruleName/add")
    public ResponseEntity<RuleName> addNewRuleName(@RequestBody RuleName ruleName) {
        logger.info("POST request on the endpoint /ruleName/add: adding an ruleName");
        RuleName ruleNameAdded = ruleNameService.addRuleName(ruleName);
        HttpStatus status;
        if (ruleNameAdded == null) {
            logger.error("Error adding ruleName");
            status = HttpStatus.BAD_REQUEST;
        }else{
            logger.info("Success adding ruleName");
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(ruleNameAdded, status);
    }

    /**
     * This method responds to a PUT request at the "/ruleName/update/{id}" URL.
     *
     * @return ResponseEntity<RuleName> If the ruleName has been updated, it returns a response entity with the ruleName and HTTP status OK.
     * If the ruleName has not been updated, it returns a response entity with a HTTP status code NOT_FOUND.
     **/
    @PutMapping("/ruleName/update/{id}")
    public ResponseEntity<RuleName> updateRuleName(@PathVariable("id") Integer ruleNameId, @RequestBody RuleName ruleName) {
        logger.info("PUT request on the endpoint /ruleName/update/{id}: updating an ruleName");
        ruleName.setRuleNameId(ruleNameId);
        RuleName ruleNameUpdated = ruleNameService.updateRuleName(ruleName);
        HttpStatus status;
        if (ruleNameUpdated == null) {
            logger.error("Error updating ruleName");
            status = HttpStatus.NOT_FOUND;
        }else{
            logger.info("Success updating ruleName");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(ruleNameUpdated, status);
    }

    /**
     * This method responds to a DELETE request at the "/ruleName/delete/{id}" URL.
     *
     * @return ResponseEntity<Void> If the ruleName has been deleted, it returns a response entity with HTTP status NO_CONTENT.
     * If the ruleName is not found, it returns a response entity with HTTP status code NOT_FOUND.
     **/
    @DeleteMapping("/ruleName/delete/{id}")
    public ResponseEntity<Void> deleteRuleName(@PathVariable("id") Integer ruleNameId) {
        logger.info("DELETE request on the endpoint /ruleName/delete/{id}: deleting an ruleName");
        Optional<RuleName> ruleName = ruleNameService.getRuleNameById(ruleNameId);
        HttpStatus status;
        if (ruleName.isEmpty()) {
            logger.error("Error deleting user: ruleName not found");
            status = HttpStatus.NOT_FOUND;
        }else{
            ruleNameService.deleteRuleNameById(ruleNameId);
            logger.info("Success deleting ruleName");
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(status);
    }
}
