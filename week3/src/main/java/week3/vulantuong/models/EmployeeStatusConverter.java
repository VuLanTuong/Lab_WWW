package com.example.week2.models;

import jakarta.persistence.AttributeConverter;

public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if (attribute == null)
            return null;
        if(EmployeeStatus.ACTIVE.equals(attribute)){
            return 1;

        }
        if(EmployeeStatus.INACTIVE.equals(attribute)){
            return 0;

        }
        return -1;
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {

        if (dbData == null)
            return null;
        if (dbData == 1) {
            return EmployeeStatus.ACTIVE;
        }

        if (dbData == -1) {
            return EmployeeStatus.TERMINAL;
        }
        return EmployeeStatus.INACTIVE;
    }
}
