package com.example.school.actions;

import com.example.school.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseAction extends CrudRepository<Course, Long> {

    List<Course> findByTag(String Tag);
}
