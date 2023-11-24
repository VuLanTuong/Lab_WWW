package com.example.week5_20020761_vulantuong.controller;

import com.example.week5_20020761_vulantuong.models.Candidate;
import com.example.week5_20020761_vulantuong.models.Job;
import com.example.week5_20020761_vulantuong.models.Skill;
import com.example.week5_20020761_vulantuong.services.AccountService;
import com.example.week5_20020761_vulantuong.services.CandidateService;
import com.example.week5_20020761_vulantuong.services.JobService;
import com.example.week5_20020761_vulantuong.services.SkillService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
public class UserController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JobService jobService;

    @Autowired
    private SkillService skillService;

    @PostMapping ("/detailJob")
    public String detailJob(Model model, @RequestParam(name="id" ,required = false) Long jobId) {

        Job job = jobService.findById(jobId);
        model.addAttribute("job", job);

        List<Skill> skills = skillService.suggestSkill(1);

        log.info("{}", skills);

        return "jobDetail";
    }

    @GetMapping("/suggestSkill")
    public String suggestSkill(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();


        Candidate candidate = candidateService.findById((Long) session.getAttribute("id"));

        List<Skill> skills = skillService.suggestSkill(candidate.getCandidateId());

        model.addAttribute("skills", skills);
        return "suggestSkill";
    }

}
