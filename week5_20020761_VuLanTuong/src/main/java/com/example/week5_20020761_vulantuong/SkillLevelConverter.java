package com.example.week5_20020761_vulantuong;

import jakarta.persistence.AttributeConverter;

public class SkillLevelConverter implements AttributeConverter {
    @Override
    public Object convertToDatabaseColumn(Object attribute) {
        return null;
    }

    @Override
    public Object convertToEntityAttribute(Object dbData) {
        return null;
    }
}
