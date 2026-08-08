package com.example.smartattendance.config;

import com.example.smartattendance.entity.AttendanceRecord;
import com.example.smartattendance.entity.AttendanceStatus;
import com.example.smartattendance.entity.Department;
import com.example.smartattendance.entity.Lecture;
import com.example.smartattendance.entity.Section;
import com.example.smartattendance.entity.Student;
import com.example.smartattendance.entity.Teacher;
import com.example.smartattendance.repository.AttendanceRecordRepository;
import com.example.smartattendance.repository.DepartmentRepository;
import com.example.smartattendance.repository.LectureRepository;
import com.example.smartattendance.repository.SectionRepository;
import com.example.smartattendance.repository.StudentRepository;
import com.example.smartattendance.repository.TeacherRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner seedData(DepartmentRepository departmentRepository,
                                      SectionRepository sectionRepository,
                                      TeacherRepository teacherRepository,
                                      StudentRepository studentRepository,
                                      LectureRepository lectureRepository,
                                      AttendanceRecordRepository attendanceRecordRepository) {
        return args -> {
            LocalDate lectureDate = LocalDate.now().plusDays(1);

            Department cse = new Department();
            cse.setCode("CSE");
            cse.setName("Computer Science and Engineering");
            cse = departmentRepository.save(cse);

            Section a = new Section();
            a.setCode("A");
            a.setName("Section A");
            a.setDepartment(cse);
            a = sectionRepository.save(a);

            Teacher teacher = new Teacher();
            teacher.setEmployeeCode("T-1001");
            teacher.setFirstName("Asha");
            teacher.setLastName("Sharma");
            teacher.setEmail("asha.sharma@example.com");
            teacher.setDepartment(cse);
            teacher = teacherRepository.save(teacher);

            Student student = new Student();
            student.setEnrollmentNo("S-2001");
            student.setFirstName("Rahul");
            student.setLastName("Verma");
            student.setEmail("rahul.verma@example.com");
            student.setDepartment(cse);
            student.setSection(a);
            student = studentRepository.save(student);

            Lecture lecture = new Lecture();
            lecture.setTitle("Introduction to Attendance System");
            lecture.setStartsAt(lectureDate.atTime(10, 0));
            lecture.setEndsAt(lectureDate.atTime(11, 0));
            lecture.setTeacher(teacher);
            lecture.setSection(a);
            lecture = lectureRepository.save(lecture);

            AttendanceRecord record = new AttendanceRecord();
            record.setAttendanceDate(lectureDate);
            record.setStatus(AttendanceStatus.PRESENT);
            record.setStudent(student);
            record.setLecture(lecture);
            attendanceRecordRepository.save(record);
        };
    }
}
