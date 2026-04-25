package com.example.hhapianalyzer.controller.secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateAdminController {

    @GetMapping("/admin")
    public String getManagementPage() {
        return "Admin Page";
    }
}
