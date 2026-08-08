package com.example.smartattendance.controller;

import com.example.smartattendance.dto.SectionRequest;
import com.example.smartattendance.entity.Section;
import com.example.smartattendance.service.SectionService;
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
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService sectionService;

    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping
    public List<Section> getAll() {
        return sectionService.findAll();
    }

    @GetMapping("/{id}")
    public Section getById(@PathVariable Long id) {
        return sectionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Section> create(@RequestBody SectionRequest request) {
        return new ResponseEntity<Section>(sectionService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Section update(@PathVariable Long id, @RequestBody SectionRequest request) {
        return sectionService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sectionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
