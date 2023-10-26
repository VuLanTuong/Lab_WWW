package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.Embeddable;

public enum SkillType {
    UNSPECIFIC(0),

    TECHNICAL_SKILL(1),

    SOFT_SKILL(2);

    SkillType(int value) {
    }

    SkillType() {

    }

}
