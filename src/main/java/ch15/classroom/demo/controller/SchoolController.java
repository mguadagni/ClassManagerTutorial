package ch15.classroom.demo.controller;

import ch15.classroom.demo.models.School;
import ch15.classroom.demo.payloads.response.MessageResponse;
import ch15.classroom.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @GetMapping("/test")
    public ResponseEntity<MessageResponse> testApi() {
        return ResponseEntity.ok(new MessageResponse("Test Route active"));
    }

    @PostMapping("/")
    public ResponseEntity<School> createSchool (@RequestBody School newSchool) {
        return ResponseEntity.ok(schoolService.saveSchool(newSchool));
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getOne(@PathVariable Long id) {
        School school = schoolService.findSchool(id);

        return ResponseEntity.ok(school);
    }

    @GetMapping("/")
    public ResponseEntity<List<School>> getAll() {
        return ResponseEntity.ok(schoolService.getAll());
    }
}
