package com.example.smartattendance.controller;

import com.example.smartattendance.dto.TeacherRequest;
import com.example.smartattendance.entity.Teacher;
import com.example.smartattendance.service.TeacherService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Teacher> create(@RequestBody TeacherRequest request) {
        return new ResponseEntity<Teacher>(teacherService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable Long id, @RequestBody TeacherRequest request) {
        return teacherService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
