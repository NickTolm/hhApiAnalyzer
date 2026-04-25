package com.example.hhapianalyzer.controller.secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateAccountController {

    @GetMapping("/account")
    public String getAccountPage() {
        return "Account page";
    }
}
