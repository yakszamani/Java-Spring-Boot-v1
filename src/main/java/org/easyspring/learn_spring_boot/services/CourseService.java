package org.easyspring.learn_spring_boot.services;

import org.easyspring.learn_spring_boot.domain.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();

    public void saveCourse(Course course);

    public Course getCourseById(Long id);

}
