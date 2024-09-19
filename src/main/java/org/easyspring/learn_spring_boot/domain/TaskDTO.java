package org.easyspring.learn_spring_boot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long id;
    private String title;
    private StudentDTO student;

    public TaskDTO(Task task, Student student) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.student = new StudentDTO(student);
    }

}
