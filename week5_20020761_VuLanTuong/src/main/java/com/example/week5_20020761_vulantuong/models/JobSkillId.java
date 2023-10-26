package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter @Getter
public class JobSkillId implements Serializable {

    @Column(name = "job_id")
    private long jobId;

    @Column(name = "skill_id")
    private long skillId;

    public JobSkillId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkillId that)) return false;
        return jobId == that.jobId && skillId == that.skillId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, skillId);
    }
}
