package org.easyspring.learn_spring_boot.Repository;

import org.easyspring.learn_spring_boot.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStudentId(Long studentId);
}
