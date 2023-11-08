package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity @Setter @Getter
public class CandidateSkill {

    @EmbeddedId
    private CandidateSkillId id;
    private String moreInfo;

    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;


    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;


    @ManyToOne
    @JoinColumn(name = "can_id", insertable = false, updatable = false)
    private Candidate candidate;

    public CandidateSkill() {
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                ", moreInfo='" + moreInfo + '\'' +
                ", skillLevel=" + skillLevel +
                ", skill=" + skill.getSkillName() +
                '}';
    }
}
