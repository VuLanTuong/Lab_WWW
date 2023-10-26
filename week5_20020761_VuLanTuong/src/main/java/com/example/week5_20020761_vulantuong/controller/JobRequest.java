package com.example.week5_20020761_vulantuong.controller;

import com.example.week5_20020761_vulantuong.models.Skill;
import com.example.week5_20020761_vulantuong.models.SkillLevel;
import com.example.week5_20020761_vulantuong.models.SkillType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class JobRequest {

    private String comName;
    private String jobName;
    private String jobDescription;
    private List<String> skills;
    private List<String> skillLevel = new ArrayList<>();

    @Override
    public String toString() {
        return "JobRequest{" +
                "comName='" + comName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", skills=" + skills +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
