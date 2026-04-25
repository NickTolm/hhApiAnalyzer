package com.example.hhapianalyzer.controller.common;

import org.springframework.web.bind.annotation.*;

@RestController
public class PublicHomeController {

    @GetMapping("/")
    public String getHomePage() {
        return "Home Page";
    }

}
