package com.example.week5_20020761_vulantuong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @PostMapping("/")
    public String postHome(){
        return "dashboard";
    }

    @GetMapping("/")
    public String getHome(){
        return "dashboard";
    }

}
