package com.abreu.crudspring.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CourseDTO(
    Long _id,
    @NotBlank @NotNull @Length(min = 5, max = 20) String name,
    @NotNull @Pattern(regexp = "back-end|front-end") @Length(max = 10) String category
) {
    
}
