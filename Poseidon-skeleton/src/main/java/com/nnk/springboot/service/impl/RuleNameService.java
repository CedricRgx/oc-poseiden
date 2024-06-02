package com.nnk.springboot.service.impl;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.exceptions.PoseidonEntityNotFoundException;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.IRuleNameService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The RuleNameService class provides business logic related to RuleName entities.
 */
@Service
public class RuleNameService implements IRuleNameService {

    private static final Logger logger = LoggerFactory.getLogger(RuleNameService.class);

    private final RuleNameRepository ruleNameRepository;

    @Autowired
    public RuleNameService(RuleNameRepository ruleNameRepository) {
        this.ruleNameRepository = ruleNameRepository;
    }

    /**
     * Retrieves all ruleNames from the repository.
     * @return A list containing all ruleNames.
     */
    public List<RuleName> getRuleNames(){
        logger.info("Retrieving the list of ruleNames");
        return ruleNameRepository.findAll();
    }

    /**
     * Retrieves a ruleName by its ID.
     * @param ruleNameId The ID of the ruleName to retrieve.
     * @return An Optional containing the ruleName, or an empty Optional if not found.
     */
    public Optional<RuleName> getRuleNameById(int ruleNameId){
        logger.info("Retrieving a ruleName by its id");
        verifyRuleNameExistence(ruleNameId);
        return ruleNameRepository.findById(ruleNameId);
    }

    /**
     * Adds a new ruleName to the repository.
     * @param ruleName The RuleName object to be added.
     * @return The added RuleName object.
     */
    @Transactional
    public RuleName addRuleName(RuleName ruleName){
        logger.info("Adding a ruleName");
        return ruleNameRepository.save(ruleName);
    }

    /**
     * Updates a ruleName in the repository.
     * @param ruleName The RuleName object to be updated.
     * @return The updated RuleName object.
     */
    @Transactional
    public RuleName updateRuleName(RuleName ruleName){
        logger.info("Updating a ruleName");
        verifyRuleNameExistence(ruleName.getId());
        return ruleNameRepository.save(ruleName);
    }

    /**
     * Deletes a ruleName by its ID.
     * @param ruleNameId The ID of the ruleName to be deleted.
     */
    @Transactional
    public void deleteRuleNameById(int ruleNameId){
        logger.info("Deleting a ruleName");
        verifyRuleNameExistence(ruleNameId);
        ruleNameRepository.deleteById(ruleNameId);
    }

    /**
     * This method checks if a RuleName with a given ID exists in the repository.
     *
     * @param id An integer representing the ID of the RuleName.
     * @throws EntityNotFoundException if no RuleName with the provided ID is found in the repository.
     */
    public void verifyRuleNameExistence(int id){
        if(!ruleNameRepository.existsById(id)){
            throw new PoseidonEntityNotFoundException("RuleName is not found ", id);
        }
    }

}
