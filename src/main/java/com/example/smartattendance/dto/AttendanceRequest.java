package com.example.smartattendance.dto;

import com.example.smartattendance.entity.AttendanceStatus;
import java.time.LocalDate;

public class AttendanceRequest {
    private LocalDate attendanceDate;
    private AttendanceStatus status;
    private Long studentId;
    private Long lectureId;

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }
}
