package com.example.week5_20020761_vulantuong.controller;

import com.example.week5_20020761_vulantuong.models.Account;
import com.example.week5_20020761_vulantuong.models.Candidate;
import com.example.week5_20020761_vulantuong.repositories.CandidateRepository;
import com.example.week5_20020761_vulantuong.services.AccountService;
import com.example.week5_20020761_vulantuong.services.CandidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@Controller
public class HomeController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private AccountService accountService;


}
