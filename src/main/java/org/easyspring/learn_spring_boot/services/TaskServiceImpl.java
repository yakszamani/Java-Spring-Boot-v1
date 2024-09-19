package org.easyspring.learn_spring_boot.services;

import lombok.RequiredArgsConstructor;
import org.easyspring.learn_spring_boot.domain.Student;
import org.easyspring.learn_spring_boot.domain.Task;
import org.easyspring.learn_spring_boot.Repository.StudentRepository;
import org.easyspring.learn_spring_boot.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public Student createStudentAndTasks(Student input) {

        //for every task, we are setting the student value. Since objects are passed by reference
        // the input(student object) is automatically updated.
        for (Task taskIn : input.getTasks()) {
            taskIn.setStudent(input);
        }
        // save Student
        Student studentOut = studentRepository.save(input);
        return studentOut;
    }
    @Override
    public String setTaskForStudent(Long id, String task) {
        // fetch Student
        Student studentTemp = studentRepository.getById(id);
        // list of tasks
        List<Task> tasks = studentTemp.getTasks();
        // new Task
        Task newTask = new Task(task);
        // set student to task
        newTask.setStudent(studentTemp);
        // add Task to list
        tasks.add(newTask);
        // add Task list to Student
        //studentTemp.setTaskList(tasks); //not required due to pass by reference
        // save Student
        studentRepository.save(studentTemp);
        return "Task saved!!!";
    }

    @Override
    public List<Task> findByStudentId(Long studentId) {
        return taskRepository.findByStudentId(studentId);
    }

    @Override
    public List<Task> all() {
        return taskRepository.findAll();
    }
}
