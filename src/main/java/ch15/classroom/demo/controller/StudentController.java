package ch15.classroom.demo.controller;

import ch15.classroom.demo.models.School;
import ch15.classroom.demo.models.Student;
import ch15.classroom.demo.models.Teacher;
import ch15.classroom.demo.payloads.request.StudentFeePay;
import ch15.classroom.demo.payloads.response.MessageResponse;
import ch15.classroom.demo.repository.StudentRepository;
import ch15.classroom.demo.service.SchoolService;
import ch15.classroom.demo.service.StudentService;
import ch15.classroom.demo.service.TeacherService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    SchoolService schoolService;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Teacher teacher = teacherService.findTeacher(student.getTeacher().getId());

        student.setTeacher(teacher);
        student.setSchool(teacher.getSchool());

        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PostMapping("/teacher/{teacherId}")
    public ResponseEntity<Student> createStudent(@RequestBody Student student, @PathVariable Long teacherId) {
        Teacher teacher = teacherService.findTeacher(teacherId);

        student.setTeacher(teacher);
        student.setSchool(teacher.getSchool());

        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);

        studentRepository.deleteById(id);
        return new ResponseEntity<>(student + " Student has been removed", HttpStatus.OK);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Student>> getByTeacher(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.findTeacher(teacherId);
        return ResponseEntity.ok(studentService.findStudents(teacher));
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getBySchool(@PathVariable Long schoolId) {
        School school = schoolService.findSchool(schoolId);
        return ResponseEntity.ok(studentService.findStudents(school));
    }

    @PostMapping("/{studentId}/payFees")
    public ResponseEntity<MessageResponse> payFees(@RequestBody StudentFeePay feePay, @PathVariable Long studentId) {
        Student student = studentService.findStudent(studentId);

        student.payFees(feePay.getAmount());

        studentService.saveStudent(student);
        return ResponseEntity.ok(new MessageResponse("Payment of " + feePay.getAmount() + " received."));
    }
}
