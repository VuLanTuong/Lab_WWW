package com.example.week5_20020761_vulantuong.controller;

import com.example.week5_20020761_vulantuong.models.Company;
import com.example.week5_20020761_vulantuong.models.Job;
import com.example.week5_20020761_vulantuong.models.Skill;
import com.example.week5_20020761_vulantuong.services.CompanyService;
import com.example.week5_20020761_vulantuong.services.JobService;
import com.example.week5_20020761_vulantuong.services.SkillService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class JobController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private JobService jobService;


    @PostMapping("/listJob")
    public String postJob(Model model){
        return "listJob";
    }

    @GetMapping("listJob")
    public String getJob(Model model){
        List<Job> jobs = jobService.findAll();

        model.addAttribute("jobs", jobs);
        return "listJob";
    }

}
