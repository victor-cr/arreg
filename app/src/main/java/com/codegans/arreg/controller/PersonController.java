package com.codegans.arreg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Java doc here
 *
 * @author Sniesariev Vitalii
 * @since 21/04/2023
 */
@Controller
public class PersonController {

    @GetMapping("/greeting")
    public String personList(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
