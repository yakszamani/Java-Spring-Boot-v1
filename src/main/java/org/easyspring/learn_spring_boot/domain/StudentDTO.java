package org.easyspring.learn_spring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String studentName;
    private String studentEmail;
    private LocalDateTime enrollDate;
    private Boolean activeEnrollment;
    private List<Task> tasks;


    public StudentDTO(Student student, List<Task> tasks) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.enrollDate = student.getEnrollDate();
        this.activeEnrollment = student.getActiveEnrollment();
        this.tasks = tasks;
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.studentName = student.getStudentName();
        this.studentEmail = student.getStudentEmail();
        this.enrollDate = student.getEnrollDate();
        this.activeEnrollment = student.getActiveEnrollment();

    }

}
