package com.accolite.restapi_au.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
    @GetMapping("/")
    public String showWelcomeMessage(){
        return "Welcome";
    }
}
