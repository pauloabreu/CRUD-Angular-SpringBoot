package com.abreu.crudspring.enums.converters;

import com.abreu.crudspring.enums.Category;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null){
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if (value == null){
            return null;
        }
        return Category.getEnumNameByValue(value);
    }
}
