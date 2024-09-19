package org.easyspring.learn_spring_boot.services;

import org.easyspring.learn_spring_boot.domain.Student;

import java.util.List;

import java.time.LocalDateTime;

public interface StudentService {

    List<Student> all();

    Student createStudent(Student input);

    Student findStudent(Long id);

    List<Student> getStudents(Long id, String studentName);

    Student upsertGeicoDomain(Student upsertInput, Long id);

    void deleteStudent(Long id);

    List<Student> getStudentsByDate(LocalDateTime enrollDate, Boolean activeEnrollment);

}
