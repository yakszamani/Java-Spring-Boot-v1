package org.easyspring.learn_spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Course;
import org.easyspring.learn_spring_boot.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Transactional
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

}
