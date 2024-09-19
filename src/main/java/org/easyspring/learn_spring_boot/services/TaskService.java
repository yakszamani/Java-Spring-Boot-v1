package org.easyspring.learn_spring_boot.services;

import org.easyspring.learn_spring_boot.domain.Student;
import org.easyspring.learn_spring_boot.domain.Task;

import java.util.List;

public interface TaskService {
    Student createStudentAndTasks(Student input);

    String setTaskForStudent(Long id, String task);

    List<Task> findByStudentId(Long studentId);

    List<Task> all();

}
