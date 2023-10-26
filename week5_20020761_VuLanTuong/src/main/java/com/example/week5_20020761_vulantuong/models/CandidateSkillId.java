package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateSkillId implements Serializable {

    @Column(name = "can_id")
    private long candidateId;
    @Column(name = "skill_id")
    private long skillId;

    public CandidateSkillId() {
    }

    public CandidateSkillId(long candidateId, long skillId) {
        this.candidateId = candidateId;
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkillId that)) return false;
        return candidateId == that.candidateId && skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId, skillId);
    }
}
