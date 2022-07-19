package ch15.classroom.demo.repository;

import ch15.classroom.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByName(String name);
    List<Student> findAllByTeacher_id(Long id);
    List<Student> findAllBySchool_id(Long id);
}
