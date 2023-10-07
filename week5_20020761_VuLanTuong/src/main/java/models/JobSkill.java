package models;

import jakarta.persistence.*;

@Entity@Table
@IdClass(JobSkillId.class)
public class JobSkill {

    private String moreInfo;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Job job;
}
