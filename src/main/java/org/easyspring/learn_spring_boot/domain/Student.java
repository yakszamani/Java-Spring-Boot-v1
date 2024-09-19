package org.easyspring.learn_spring_boot.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private @Id
    @GeneratedValue Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Name must be minimum 2 characters, and maximum 30 characters long")
    private String studentName;
    @NotNull
    @Email
    private String studentEmail;

    private LocalDateTime enrollDate;
    private Boolean activeEnrollment;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Student(String studentName, String studentEmail) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    @JsonManagedReference
    public List<Task> getTasks() {
        return tasks;
    }


    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Course.class)
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    /*
    @JsonManagedReference
    public Set<Course> getCourses() {
        return courses;
    }

     */

}
