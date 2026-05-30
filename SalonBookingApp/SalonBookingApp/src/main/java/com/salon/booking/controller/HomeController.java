package com.salon.booking.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String HoneControllerHandler(){
        return "Home Controller";
    }
}
