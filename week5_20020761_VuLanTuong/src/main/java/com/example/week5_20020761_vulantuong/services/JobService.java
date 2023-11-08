package com.example.week5_20020761_vulantuong.services;

import com.example.week5_20020761_vulantuong.controller.JobRequest;
import com.example.week5_20020761_vulantuong.models.*;
import com.example.week5_20020761_vulantuong.repositories.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private JobSkillService jobSkillService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public long getLatestId(){
        String sql = "SELECT MAX(job_id) AS largest_job_id\n" +
                "FROM job";
        Long result = jdbcTemplate.queryForObject(sql, Long.class);
        return result != null ? result : 0L;

    }

    public List<Job> findAll(){
        return  jobRepository.findAll();
    }
    public void insertJob(JobRequest jobRequest){
        Company company = new Company();
        company = companyService.findByName(jobRequest.getComName());

        List<String> filteredList = new ArrayList<>();
        for (String skill : jobRequest.getSkillLevel()) {
            if (skill != null && !skill.isEmpty()) {
                filteredList.add(skill);
                log.info("{}", filteredList);
            }
        }
        List<JobSkill> jobSkills = new ArrayList<>();
        Job job = new Job();



        job.setJobName(jobRequest.getJobName());
        job.setJobDescription(jobRequest.getJobDescription());
        job.setCompany(company);


        jobRepository.saveAndFlush(job);

//        log.info("{IDDDDDDDDDDDDDDD}{}", job );
//        long lastestId = getLatestId();
//
//
//        Job job2 = jobRepository.findByJobId(lastestId);
//
//        log.info("{JOB222222}{}", job2);

        for(int i = 0; i < jobRequest.getSkills().size(); i++){
                 Skill skill = skillService.findBySkillName(jobRequest.getSkills().get(i));
                SkillLevel skillLevel = SkillLevel.valueOf(filteredList.get(i));
                JobSkill jobSkill = new JobSkill();
                JobSkillId jobSkillId = new JobSkillId();

                jobSkillId.setJobId(job.getJobId());
                jobSkillId.setSkillId(skill.getSkillId());

                jobSkill.setId(jobSkillId);
                jobSkill.setJob(job);
                jobSkill.setSkill(skill);
                jobSkill.setSkillLevel(skillLevel);
                jobSkillService.insertJobSkill(jobSkill);

                jobSkills.add(jobSkill);
            }
            job.setSkills(jobSkills);
            jobRepository.saveAndFlush(job);
        }


        public List<Job> findByCompany(Long id){
        return jobRepository.findByCompanyId(id);
        }
    }

