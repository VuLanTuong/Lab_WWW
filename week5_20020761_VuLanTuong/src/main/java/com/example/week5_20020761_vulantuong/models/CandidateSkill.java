package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;

@Table
@Entity
public class CandidateSkill {

    @EmbeddedId
    private CandidateSkillId id;
    private String moreInfo;

    @Embedded
    @Enumerated(EnumType.STRING)
    private SkillLevel skillLevel;


    @ManyToOne
    @JoinColumn(name = "skill_id", insertable = false, updatable = false)
    private Skill skill;



    @ManyToOne
    @JoinColumn(name = "can_id", insertable = false, updatable = false)
    private Candidate caniddate;

    public CandidateSkill() {
    }
}
