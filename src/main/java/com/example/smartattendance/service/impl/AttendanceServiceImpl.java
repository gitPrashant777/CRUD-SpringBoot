package com.example.smartattendance.service.impl;

import com.example.smartattendance.dto.AttendanceRequest;
import com.example.smartattendance.entity.AttendanceRecord;
import com.example.smartattendance.entity.Lecture;
import com.example.smartattendance.entity.Student;
import com.example.smartattendance.exception.ResourceNotFoundException;
import com.example.smartattendance.repository.AttendanceRecordRepository;
import com.example.smartattendance.repository.LectureRepository;
import com.example.smartattendance.repository.StudentRepository;
import com.example.smartattendance.service.AttendanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRecordRepository attendanceRecordRepository;
    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    public AttendanceServiceImpl(AttendanceRecordRepository attendanceRecordRepository, StudentRepository studentRepository, LectureRepository lectureRepository) {
        this.attendanceRecordRepository = attendanceRecordRepository;
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    public List<AttendanceRecord> findAll() {
        return attendanceRecordRepository.findAll();
    }

    public AttendanceRecord findById(Long id) {
        return attendanceRecordRepository.findById(id)
            .orElseThrow(new ResourceNotFoundException("Attendance record not found: " + id));
    }

    public AttendanceRecord create(AttendanceRequest request) {
        Student student = studentRepository.findById(request.getStudentId())
            .orElseThrow(new ResourceNotFoundException("Student not found: " + request.getStudentId()));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
            .orElseThrow(new ResourceNotFoundException("Lecture not found: " + request.getLectureId()));
        AttendanceRecord attendanceRecord = new AttendanceRecord();
        attendanceRecord.setAttendanceDate(request.getAttendanceDate());
        attendanceRecord.setStatus(request.getStatus());
        attendanceRecord.setStudent(student);
        attendanceRecord.setLecture(lecture);
        return attendanceRecordRepository.save(attendanceRecord);
    }

    public AttendanceRecord update(Long id, AttendanceRequest request) {
        AttendanceRecord attendanceRecord = findById(id);
        Student student = studentRepository.findById(request.getStudentId())
            .orElseThrow(new ResourceNotFoundException("Student not found: " + request.getStudentId()));
        Lecture lecture = lectureRepository.findById(request.getLectureId())
            .orElseThrow(new ResourceNotFoundException("Lecture not found: " + request.getLectureId()));
        attendanceRecord.setAttendanceDate(request.getAttendanceDate());
        attendanceRecord.setStatus(request.getStatus());
        attendanceRecord.setStudent(student);
        attendanceRecord.setLecture(lecture);
        return attendanceRecordRepository.save(attendanceRecord);
    }

    public void delete(Long id) {
        attendanceRecordRepository.delete(findById(id));
    }
}
