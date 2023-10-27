package com.example.gk4.convert;

import com.example.gk4.models.IsGrant;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class IsGrantConverter implements AttributeConverter<IsGrant, Integer> {
    @Override
    public Integer convertToDatabaseColumn(IsGrant attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public IsGrant convertToEntityAttribute(Integer dbData) {
        if(dbData == null){
            return null;
        }
        return Stream.of(IsGrant.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow((IllegalAccessError::new));
    }
}
