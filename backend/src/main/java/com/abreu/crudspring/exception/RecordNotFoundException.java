package com.abreu.crudspring.exception;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id){
        super(String.format("Course of %d id has not found!", id));
    }
}
