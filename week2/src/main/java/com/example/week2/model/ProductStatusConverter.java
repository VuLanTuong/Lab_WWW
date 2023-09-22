package com.example.week2.model;

import jakarta.persistence.AttributeConverter;

public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if (attribute == null) {
            return null;
        }
        if(EmployeeStatus.ACTIVE.equals(attribute)){
            return 1;

        }
        if(EmployeeStatus.INACTIVE.equals(attribute)){
            return 0;

        }
        return -1;
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        if (dbData == 1) {
            return ProductStatus.ACTIVE;
        }

        if (dbData == -1) {
            return ProductStatus.TERMINAL;
        }
        return ProductStatus.INACTIVE;
    }
}
