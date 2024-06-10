package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.impl.CurvePointService;
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
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling curvePoint in the Poseidon application
 */
@Controller
public class CurvePointController {
    
    private static final Logger logger = LoggerFactory.getLogger(CurvePointController.class);
    
    private final CurvePointService curvePointService;

    @Autowired
    public CurvePointController(CurvePointService curvePointService) {
        this.curvePointService = curvePointService;
    }
    
    /**
     * Displays the list of curvePoints.
     *
     * @param model The model for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of curvePoints.
     */
    @GetMapping("/curvePoint/list")
    public String home(Model model){
        logger.info("Loading Curve Point list page");
        List<CurvePoint> curvePoints = curvePointService.getCurvePoints();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(curvePoints == null) {
            logger.error("Error retrieving curvePoints for list page");
        } else {
            logger.info("Successfully retrieved curvePoints for list page");
            model.addAttribute("curvePoints", curvePoints);
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                model.addAttribute("user", userDetails);
            } else if (principal instanceof DefaultOAuth2User) {
                DefaultOAuth2User oauth2User = (DefaultOAuth2User) principal;
                model.addAttribute("user", oauth2User.getAttributes());
            }
        }
        return "curvePoint/list";
    }

    /**
     * Displays the view to add a curvePoint.
     *
     * @param curve The curve to add for the view to add attributes to be rendered on the page.
     * @return The name of the template to render the list of curvePoints.
     */
    @GetMapping("/curvePoint/add")
    public String addCurveForm(CurvePoint curve) {
        logger.info("Loading add curve form");
        return "curvePoint/add";
    }

    /**
     * Handles the POST request to validate and save a curve point.
     *
     * @param curvePoint The curve point to be validated and saved.
     * @param result The binding result which holds the validation results for the curve point.
     * @param model The Model object to be used in the view.
     * @return A String indicating the next view. If there are errors, it returns to the add view.
     *         If the curve point is successfully saved, it redirects to the curve point view.
     */
    @PostMapping("/curvePoint/validate")
    public String validate(@Valid @ModelAttribute("curvePoint") CurvePoint curvePoint, BindingResult result, Model model) {
        logger.info("Curve Point validation started");
        if(result.hasErrors()) {
            model.addAttribute("curvePoint", curvePoint);
            logger.error("Curve Point validation has errors");
            return "curvePoint/add";
        }
        curvePointService.addCurvePoint(curvePoint);
        logger.info("Curve Point validation finished successfully, Curve Point added");
        return "redirect:/curvePoint/list";
    }

    /**
     * Handles the GET request to display the form for updating a curve point.
     *
     * @param id The id of the curve point to be updated.
     * @param model The Model object to be used in the view.
     * @return A String that represents the view to be returned.
     *         This is the update view for the curve point.
     */
    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        logger.info("Show update form for Curve Point with id: " + id);
        Optional<CurvePoint> bid = curvePointService.getCurvePointById(id);
        if(bid.isPresent()) {
            model.addAttribute("curvePoint", bid.get());
        }else{
            logger.warn("Curve Point with id: " + id + " not found");
        }
        return "curvePoint/update";
    }

    /**
     * Handles the POST request to update a curve point.
     *
     * @param id The id of the curve point to be updated.
     * @param curvePoint The updated curve point.
     * @param result The binding result which holds the validation results for the curve point.
     * @param model The Model object to be used in the view.
     * @return A string indicating the next view. If there are errors, it returns to the update view.
     *         If the bid list is successfully updated, it redirects to the list view.
     */
    @PostMapping("/curvePoint/update/{id}")
    public String updateCurve(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint, BindingResult result, Model model) {
        logger.info("Updating Curve Point with id: " + id);
        if(result.hasErrors()) {
            model.addAttribute("curvePoint", curvePoint);
            logger.error("Error updating Curve Point with id: " + id);
            return "curvePoint/update";
        }
        curvePointService.updateCurvePoint(curvePoint);
        logger.info("Updated Curve Point with id: " + id);
        return "redirect:/curvePoint/list";
    }

    /**
     * Handles the POST request to delete a curve point by id.
     *
     * @param id    The id of the curve point to be deleted.
     * @param model The Model object to be used in the view.
     * @return A String that represents the list of curve to be returned.
     */
    @PostMapping("/curvePoint/delete/{id}")
    public String deleteCurve(@PathVariable("id") Integer id, Model model) {
        logger.info("Deleting Curve Point with id: " + id);
        curvePointService.deleteCurvePointById(id);
        logger.info("Deleted Curve Point with id: " + id);
        return "redirect:/curvePoint/list";
    }

}