package org.easyspring.learn_spring_boot.Repository;

import org.easyspring.learn_spring_boot.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
