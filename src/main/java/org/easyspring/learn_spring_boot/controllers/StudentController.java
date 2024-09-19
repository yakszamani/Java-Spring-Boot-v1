package org.easyspring.learn_spring_boot.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Student;
import org.easyspring.learn_spring_boot.services.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.ObjectError;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

//    public StudentController(@Qualifier("StudentServiceImpl") StudentService service) {
//        this.service = service;
//    }

    //http://localhost:8080/allstudents
    @GetMapping("/allstudents")
    public List<Student> all() {
        return service.all();
    }

    @PostMapping("/registerstudent")
    public ResponseEntity<?> registerNewStudent(@RequestBody @Valid Student student) {
        Student createdStudent = service.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }


    @GetMapping("/findstudent/{id}")
    public Student one(@PathVariable Long id) {
        return service.findStudent(id);
    }
    @PutMapping("/updatestudent/{id}")
    Student upsert(@RequestBody Student input, @PathVariable Long id) {
        return service.upsertGeicoDomain(input, id);
    }

    @DeleteMapping("/deletestudent/{id}")
    void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @GetMapping(value = "/studentsearchbyidorname", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getResources(
            @RequestParam Long id,
            @RequestParam String studentName
    ) {
        return new ResponseEntity<>
                (service.getStudents(id, studentName), HttpStatus.OK);
    }

    @GetMapping(value = "/studentsbydate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByDate(
            @RequestParam String enrollDate,
            @RequestParam Boolean activeEnrollment
    ) {
        return new ResponseEntity<>
                (service.getStudentsByDate(LocalDateTime.parse(enrollDate), activeEnrollment), HttpStatus.OK);
    }


}

