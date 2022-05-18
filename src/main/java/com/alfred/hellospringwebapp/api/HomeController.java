package com.alfred.hellospringwebapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @GetMapping
    public String home () {
        return "Application is working!!! "+ " " + new Date();
    }

}
