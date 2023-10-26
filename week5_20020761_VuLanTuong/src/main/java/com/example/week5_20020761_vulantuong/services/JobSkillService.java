package com.example.week5_20020761_vulantuong.services;

import com.example.week5_20020761_vulantuong.models.JobSkill;
import com.example.week5_20020761_vulantuong.repositories.JobSkillReppository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSkillService {
    @Autowired
    private JobSkillReppository jobSkillReppository;
    public void insertJobSkill(JobSkill jobSkill){
            jobSkillReppository.save(jobSkill);

    }
}
