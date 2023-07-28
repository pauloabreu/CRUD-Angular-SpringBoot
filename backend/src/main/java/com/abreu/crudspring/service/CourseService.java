package com.abreu.crudspring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.abreu.crudspring.exception.RecordNotFoundException;
import com.abreu.crudspring.model.Course;
import com.abreu.crudspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    public List<Course> list(){
        return courseRepository.findAll();
    }

    public Course findById(@PathVariable @NotNull @Positive Long id){
        return courseRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Course create(@Valid Course course){
        return courseRepository.save(course);
    }

    public Course update(@NotNull @Positive Long id, @Valid Course course) {
        return courseRepository.findById(id)
            .map(courseFound -> {
                courseFound.setName(course.getName());
                courseFound.setCategory(course.getCategory());
                return courseRepository.save(courseFound);
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id){
        courseRepository.delete(
            courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id))
        );
    } 

}
