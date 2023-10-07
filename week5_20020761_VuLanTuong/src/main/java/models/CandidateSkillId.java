package models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;
import java.util.Objects;

public class CandidateSkillId implements Serializable {
    private long candidateId;
    private long skillId;

    public CandidateSkillId() {
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
