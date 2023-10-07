package models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long skillId;
    private String skillDescription;
    private String skillName;

    @Embedded
    private SkillType type;


    public Skill() {
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
