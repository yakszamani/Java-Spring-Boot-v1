package org.easyspring.learn_spring_boot.controllers;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Student;
import org.easyspring.learn_spring_boot.domain.StudentDTO;
import org.easyspring.learn_spring_boot.domain.Task;
import org.easyspring.learn_spring_boot.domain.TaskDTO;
import org.easyspring.learn_spring_boot.services.StudentService;
import org.easyspring.learn_spring_boot.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final StudentService studentService;
    private final TaskService taskService;

    @PostMapping("/savestudentandtask")
    public String saveStudentAndTask(@RequestBody Student student) {

        Student createdStudent = taskService.createStudentAndTasks(student);

        return "Student and tasks saved!!";
    }

    @PostMapping("/settaskforstudent")
    public String setTaskForStudent(@RequestParam(name = "id") String id, @RequestParam String task) {

        String result = taskService.setTaskForStudent(Long.valueOf(id), task);
        return result;

    }

    @GetMapping("/allstudentswithtasks")
    public ResponseEntity<List<StudentDTO>> getAllStudentsWithTasks() {
        List<Student> students = studentService.all();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            List<Task> tasks = taskService.findByStudentId(student.getId());
            studentDTOs.add(new StudentDTO(student, tasks));
        }

        return ResponseEntity.ok(studentDTOs);
    }

    @GetMapping("/alltaskswithstudents")
    public ResponseEntity<List<TaskDTO>> getAllTasksWithStudents() {
        List<Task> tasks = taskService.all();
        List<TaskDTO> taskDTOs = new ArrayList<>();

        for (Task task : tasks) {
            Student student = task.getStudent();
            taskDTOs.add(new TaskDTO(task, student));
        }

        return ResponseEntity.ok(taskDTOs);
    }


}
