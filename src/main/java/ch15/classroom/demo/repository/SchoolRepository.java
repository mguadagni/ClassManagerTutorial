package ch15.classroom.demo.repository;

import ch15.classroom.demo.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByName(String Name);
}
