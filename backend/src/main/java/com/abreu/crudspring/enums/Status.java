package com.abreu.crudspring.enums;

import java.util.Arrays;


public enum Status {
    ACTIVE("active"), INACTIVE("inactive");

    private String value;

    private Status(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }

    public static Status getEnumNameByValue(String value) {
        return Arrays.stream(Status.values())
            .filter(status -> status.value.equals(value))
            .findFirst()
            .orElseThrow();
    }
}
