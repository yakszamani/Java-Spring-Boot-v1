package org.easyspring.learn_spring_boot.Repository;

import org.easyspring.learn_spring_boot.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT st FROM Student st WHERE st.id = ?1 OR st.studentName = ?2")
    List<Student> findAsOfDateEntities(
            Long id, String studentName);

    @Query(value = "SELECT st FROM Student st WHERE st.enrollDate <= ?1 AND st.activeEnrollment = ?2")
    List<Student> findAsOfDateStudents(
            LocalDateTime enrollDate, Boolean activeEnrollment);

}
