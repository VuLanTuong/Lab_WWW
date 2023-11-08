package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table
@Getter @Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long skillId;
    private String skillDescription;
    private String skillName;


    @Enumerated(EnumType.STRING)
    private SkillType type;


    public Skill() {
    }

    public Skill(long skillId, String skillDescription, String skillName, SkillType type) {
        this.skillId = skillId;
        this.skillDescription = skillDescription;
        this.skillName = skillName;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill skill)) return false;
        return skillId == skill.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillId);
    }


}
