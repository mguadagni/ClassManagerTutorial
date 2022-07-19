package ch15.classroom.demo.repository;

import ch15.classroom.demo.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllBySchool_id(Long id);
}
