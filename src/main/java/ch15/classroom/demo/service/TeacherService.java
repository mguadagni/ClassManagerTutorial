package ch15.classroom.demo.service;

import ch15.classroom.demo.models.School;
import ch15.classroom.demo.models.Teacher;
import ch15.classroom.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Teacher> getSchoolTeachers(School school) { return teacherRepository.findAllBySchool_id(school.getId()); }
}
