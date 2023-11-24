package com.example.week5_20020761_vulantuong.services;

import com.example.week5_20020761_vulantuong.models.Skill;
import com.example.week5_20020761_vulantuong.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;


    public List<Skill> getAll(){
        return skillRepository.findAll();
    }

    public Skill findBySkillName(String skillName){
        return skillRepository.findBySkillName(skillName);
    }

    public List<Skill> suggestSkill(long id){
        return skillRepository.suggestForCandidate(id);
    }
}
