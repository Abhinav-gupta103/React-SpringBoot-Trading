package com.zosh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String home() {
        return "welcome to Trading Platform";
    }

    @GetMapping("api/secure")
    public String secure() {
        return "welcome to Trading Platform secure";
    }
}
