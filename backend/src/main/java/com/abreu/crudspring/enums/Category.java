package com.abreu.crudspring.enums;

import java.util.Arrays;


public enum Category {
    BACK_END("back-end"), FRONT_END("front-end");

    private String value;

    private Category(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }

    public static Category getEnumNameByValue(String value) {
        return Arrays.stream(Category.values())
            .filter(cat -> cat.value.equals(value))
            .findFirst()
            .orElseThrow();
    }
}
