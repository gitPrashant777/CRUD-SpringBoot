package com.example.smartattendance.controller;

import com.example.smartattendance.dto.LectureRequest;
import com.example.smartattendance.entity.Lecture;
import com.example.smartattendance.service.LectureService;
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
@RequestMapping("/api/lectures")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<Lecture> getAll() {
        return lectureService.findAll();
    }

    @GetMapping("/{id}")
    public Lecture getById(@PathVariable Long id) {
        return lectureService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Lecture> create(@RequestBody LectureRequest request) {
        return new ResponseEntity<Lecture>(lectureService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Lecture update(@PathVariable Long id, @RequestBody LectureRequest request) {
        return lectureService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lectureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
