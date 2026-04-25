package com.example.hhapianalyzer.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestControllerAdvice
public class GlobalExceptionHandler {

    @PostMapping("/error-page")
    public String getErrorPage() {
        return "Error page";
    }

    @ExceptionHandler(Throwable.class)
    public String handleThrowable(Throwable throwable) {
        return "redirect:/error-page";
    }
}
