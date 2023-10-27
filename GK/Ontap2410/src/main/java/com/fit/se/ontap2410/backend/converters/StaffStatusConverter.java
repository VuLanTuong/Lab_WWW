package com.fit.se.ontap2410.backend.converters;

import com.fit.se.ontap2410.backend.enums.StaffStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

// convert de insert va database vi database la int khong phai enum
@Converter
public class StaffStatusConverter implements AttributeConverter<StaffStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(StaffStatus attribute) {
       if(attribute == null){
           return null;
       }
       return attribute.getValue();
    }

    @Override
    public StaffStatus convertToEntityAttribute(Integer dbData) {
       if(dbData == null){
           return null;
       }
        return Stream.of(StaffStatus.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
