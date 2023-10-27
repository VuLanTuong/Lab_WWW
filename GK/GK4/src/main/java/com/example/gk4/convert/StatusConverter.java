package com.example.gk4.convert;

import com.example.gk4.models.Status;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        return Stream.of(Status.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Status value: " + dbData));
    }
}
