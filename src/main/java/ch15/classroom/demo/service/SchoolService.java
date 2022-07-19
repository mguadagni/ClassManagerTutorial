package ch15.classroom.demo.service;

import ch15.classroom.demo.models.School;
import ch15.classroom.demo.models.Student;
import ch15.classroom.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School findSchool(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public School findSchool(String name) {
        return schoolRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<School> findSchools() {
        return schoolRepository.findAll();
    }

    public Integer totalMoneyEarned(Long id) {
        School school = findSchool(id);

        return school.getMoneyEarned();
    }

    public List<School> getAll() {
        return schoolRepository.findAll();
    }
}
