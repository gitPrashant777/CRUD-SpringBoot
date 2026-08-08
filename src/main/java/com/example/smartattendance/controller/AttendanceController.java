package com.example.smartattendance.controller;

import com.example.smartattendance.dto.AttendanceRequest;
import com.example.smartattendance.entity.AttendanceRecord;
import com.example.smartattendance.service.AttendanceService;
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
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public List<AttendanceRecord> getAll() {
        return attendanceService.findAll();
    }

    @GetMapping("/{id}")
    public AttendanceRecord getById(@PathVariable Long id) {
        return attendanceService.findById(id);
    }

    @PostMapping
    public ResponseEntity<AttendanceRecord> create(@RequestBody AttendanceRequest request) {
        return new ResponseEntity<AttendanceRecord>(attendanceService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public AttendanceRecord update(@PathVariable Long id, @RequestBody AttendanceRequest request) {
        return attendanceService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attendanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
