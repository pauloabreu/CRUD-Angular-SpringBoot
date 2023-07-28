package com.abreu.crudspring.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "back-end|front-end")
    @Length(max = 10)
    @Column(length = 10, nullable = false)
    private String category;

    @NotNull
    @Pattern(regexp = "active|inactive")
    @Length(max = 10)
    @Column(length = 10, nullable = false)
    private String status = "active";
}
