package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter @Getter
public class JobSkill {

    @EmbeddedId
    private JobSkillId id;

    private String moreInfo;

    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "job_id", insertable = false, updatable = false, nullable = false)
    private Job job;


    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;

    public JobSkill() {
    }

    public JobSkill(JobSkillId id, String moreInfo, Skill skill, Job job, SkillLevel skillLevel) {
        this.id = id;
        this.moreInfo = moreInfo;
        this.skill = skill;
        this.job = job;
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "moreInfo='" + moreInfo + '\'' +
                ", skillName=" + skill.getSkillName() +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
