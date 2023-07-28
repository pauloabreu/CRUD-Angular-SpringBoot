package com.abreu.crudspring.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.abreu.crudspring.enums.Category;
import com.abreu.crudspring.enums.Status;
import com.abreu.crudspring.enums.converters.CategoryConverter;
import com.abreu.crudspring.enums.converters.StatusConverter;
import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'inactive' WHERE id = ?")
@Where(clause = "status = 'active'")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private long id;
    
    @NotBlank
    @NotNull
    @Length(min = 5, max = 20)
    @Column(length = 20, nullable = false)
    private String name;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;
}
