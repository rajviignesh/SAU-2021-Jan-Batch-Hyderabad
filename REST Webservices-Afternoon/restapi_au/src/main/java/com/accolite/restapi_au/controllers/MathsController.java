package com.accolite.restapi_au.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maths")
public class MathsController {

    @GetMapping("/add")
    public Integer add(@RequestParam("num1") Integer n1,
                       @RequestParam("num2") Integer n2){
        return n1 + n2;
    }

    @GetMapping("/mult/{n1}/{n2}")
    public Integer mult(@PathVariable("n1") Integer n1,
                       @PathVariable("n2") Integer n2){
        return n1 * n2;
    }
}
