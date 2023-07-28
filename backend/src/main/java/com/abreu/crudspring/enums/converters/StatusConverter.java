package com.abreu.crudspring.enums.converters;

import com.abreu.crudspring.enums.Status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String>{

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null){
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if (value == null){
            return null;
        }
        return Status.getEnumNameByValue(value);
    }
}
