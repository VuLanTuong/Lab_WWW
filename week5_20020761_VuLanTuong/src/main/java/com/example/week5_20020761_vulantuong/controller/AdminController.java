package com.example.week5_20020761_vulantuong.controller;

import com.example.week5_20020761_vulantuong.models.*;
import com.example.week5_20020761_vulantuong.services.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class AdminController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private JobService jobService;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private AccountService accountService;
    @GetMapping("/insertJob")
    public String insertJob(Model model, @RequestParam("id") Long companyId) {

        Optional<Company> companies = companyService.findById(companyId);

        Company company = companies.get();
        model.addAttribute("company",company);
        List<Skill> skillList = skillService.getAll();
        model.addAttribute(skillList);
        JobRequest jobRequest = new JobRequest();
        model.addAttribute(jobRequest);
        return "insertJob";
    }

    @GetMapping("/getAll")
    public String getAll(Model model, @RequestParam("id") Long companyId) {
        List< Job> jobs = jobService.findByCompany(companyId);
        model.addAttribute("jobs", jobs);
        return "listJob";
    }

        @PostMapping("/save")
    public String saveNewJob(HttpServletRequest request, HttpServletResponse response, JobRequest jobRequest) {

        jobService.insertJob(jobRequest);

        log.info("{JOBBBBBBBBBB}{}", jobRequest);
        return "redirect:/listCandidate";
    }


    @GetMapping("/listCandidate")
    public String listCandidate(Model model,
                                @RequestParam("companyId") Long companyId,
                                RedirectAttributes redirectAttributes){

        List<Candidate> list = candidateService.suggestCandidate(companyId);


        model.addAttribute("candidates", list);
        model.addAttribute("comId", companyId);
        return "/listCandidate";
    }

    @GetMapping("/")
    public String login(){
//
//        List<Candidate> list = candidateService.suggestCandidate(1L);
//
//        log.info("{}", list);

        return "login";
    }

    @PostMapping ("/")
    public String getHome(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model,
                          RedirectAttributes redirectAttributes){

        Account account = accountService.findAccooutn(username, password);



        if(account.getCandidate() != null){
            return "redirect:/listJob";

        }


        Long companyId = account.getCompany().getCompId();
        redirectAttributes.addAttribute("companyId", companyId);
        return "redirect:/listCandidate";
    }


    @GetMapping("/candidates")
    public String getAllCandidate(Model model){
        List<Candidate> candidates = candidateService.getAll();
        model.addAttribute("candidates", candidates);
        return "candidates";

    }
}
