package ch15.classroom.demo.controller;

import ch15.classroom.demo.models.School;
import ch15.classroom.demo.models.Teacher;
import ch15.classroom.demo.service.SchoolService;
import ch15.classroom.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    SchoolService schoolService;

    @PostMapping("/")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {

        School school = schoolService.findSchool(teacher.getSchool().getId());

        teacher.setSchool(school);

        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }

    @PostMapping("/school/{schoolId}")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher, @PathVariable Long schoolId) {

        School school = schoolService.findSchool(schoolId);

        teacher.setSchool(school);

        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getOne(@PathVariable Long id) {
        Teacher teacher = teacherService.findTeacher(id);

        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Teacher>> getTeachers(@PathVariable long schoolId) {
        School school = schoolService.findSchool(schoolId);

        return ResponseEntity.ok(teacherService.getSchoolTeachers(school));
    }


}
