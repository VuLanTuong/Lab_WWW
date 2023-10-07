package models;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable @NoArgsConstructor
public enum SkillLevel {
    MASTER(5),

    PROFESSIONAL(4),

    ADVANCED(3),

    IMTERMEDIATE(2),

    BEGINER(1);

    SkillLevel(int value) {
    }

}
