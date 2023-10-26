package com.example.week5_20020761_vulantuong.models;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

 @NoArgsConstructor
public enum SkillLevel {
    MASTER,

    PROFESSIONAL,

    ADVANCED,

    IMTERMEDIATE,

    BEGINER;

    SkillLevel(String value) {
    }

}
