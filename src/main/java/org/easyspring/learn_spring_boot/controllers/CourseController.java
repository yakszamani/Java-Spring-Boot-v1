package org.easyspring.learn_spring_boot.controllers;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Course;
import org.easyspring.learn_spring_boot.domain.Student;
import org.easyspring.learn_spring_boot.services.CourseService;
import org.easyspring.learn_spring_boot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/allcourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/savecourse")
    public String saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course saved!";
    }

    @PostMapping("/registerforcourse/student/{studentId}/course/{courseId}")
    public String registerStudentForCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        Student student = studentService.findStudent(studentId);
        Course course = courseService.getCourseById(courseId);

        if (student != null && course != null) {
            student.getCourses().add(course);

            studentService.createStudent(student);

        } else {
            // Handle invalid student or course IDs
            throw new RuntimeException("Invalid student or course ID");
        }
        return "Student Registered!";
    }
}
