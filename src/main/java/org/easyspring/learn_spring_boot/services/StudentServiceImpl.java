package org.easyspring.learn_spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Student;
import org.easyspring.learn_spring_boot.domain.StudentNotFoundException;
import org.easyspring.learn_spring_boot.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.List;

@Qualifier("StudentServiceImpl")
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

/*
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    */

    @Override
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student createStudent(Student input) {
        return studentRepository.save(input);
    }

    @Override
    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public List<Student> getStudents(Long id, String studentName) {
        return studentRepository.findAsOfDateEntities(id, studentName);
    }

    @Override
    @Transactional
    public Student upsertGeicoDomain(Student upsertInput, Long id) {
        return studentRepository.findById(id)
                .map(found -> {
                    found.setStudentName(upsertInput.getStudentName());
                    found.setStudentEmail(upsertInput.getStudentEmail());
                    found.setEnrollDate(upsertInput.getEnrollDate());
                    found.setActiveEnrollment(upsertInput.getActiveEnrollment());
                    return studentRepository.save(found);
                })
                .orElseGet(() -> {
                    upsertInput.setId(id);
                    return studentRepository.save(upsertInput);
                });
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByDate(LocalDateTime enrollDate, Boolean activeEnrollment) {
        return studentRepository.findAsOfDateStudents(enrollDate, activeEnrollment);
    }

}
