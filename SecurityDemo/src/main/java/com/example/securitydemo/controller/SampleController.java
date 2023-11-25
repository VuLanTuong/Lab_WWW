package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SampleController {


        @GetMapping
        public String hello(){
            return "hello world";
        }


}
