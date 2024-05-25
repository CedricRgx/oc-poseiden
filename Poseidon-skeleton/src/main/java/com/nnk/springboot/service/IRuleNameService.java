package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;

import java.util.List;
import java.util.Optional;

public interface IRuleNameService {

    /**
     * Retrieves all ruleNames from the repository.
     * @return A list containing all ruleNames.
     */
    public List<RuleName> getRuleNames();

    /**
     * Retrieves a ruleName by its ID.
     * @param ruleNameId The ID of the ruleName to retrieve.
     * @return An Optional containing the ruleName, or an empty Optional if not found.
     */
    public Optional<RuleName> getRuleNameById(int ruleNameId);

    /**
     * Adds a new ruleName to the repository.
     * @param ruleName The RuleName object to be added.
     * @return The added RuleName object.
     */
    public RuleName addRuleName(RuleName ruleName);

    /**
     * Updates a ruleName in the repository.
     * @param ruleName The ruleName object to be updated.
     * @return The updated ruleName object.
     */
    public RuleName updateRuleName(RuleName ruleName);

    /**
     * Deletes a ruleName by their ID.
     * @param ruleNameId The ID of the ruleName to be deleted.
     */
    public void deleteRuleNameById(int ruleNameId);

}