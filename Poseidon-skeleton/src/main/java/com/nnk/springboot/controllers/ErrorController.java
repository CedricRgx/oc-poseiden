package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    /**
     * Displays the error page
     *
     * @return The name of the 403 error template
     */
    @GetMapping("/403")
    public String error403() {
        return "403";
    }

}
