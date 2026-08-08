package com.example.smartattendance.service.impl;

import com.example.smartattendance.dto.StudentRequest;
import com.example.smartattendance.entity.Department;
import com.example.smartattendance.entity.Section;
import com.example.smartattendance.entity.Student;
import com.example.smartattendance.exception.ResourceNotFoundException;
import com.example.smartattendance.repository.DepartmentRepository;
import com.example.smartattendance.repository.SectionRepository;
import com.example.smartattendance.repository.StudentRepository;
import com.example.smartattendance.service.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final SectionRepository sectionRepository;

    public StudentServiceImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository, SectionRepository sectionRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(new ResourceNotFoundException("Student not found: " + id));
    }

    public Student create(StudentRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(new ResourceNotFoundException("Department not found: " + request.getDepartmentId()));
        Section section = sectionRepository.findById(request.getSectionId())
            .orElseThrow(new ResourceNotFoundException("Section not found: " + request.getSectionId()));
        Student student = new Student();
        student.setEnrollmentNo(request.getEnrollmentNo());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setDepartment(department);
        student.setSection(section);
        return studentRepository.save(student);
    }

    public Student update(Long id, StudentRequest request) {
        Student student = findById(id);
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(new ResourceNotFoundException("Department not found: " + request.getDepartmentId()));
        Section section = sectionRepository.findById(request.getSectionId())
            .orElseThrow(new ResourceNotFoundException("Section not found: " + request.getSectionId()));
        student.setEnrollmentNo(request.getEnrollmentNo());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setDepartment(department);
        student.setSection(section);
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.delete(findById(id));
    }
}
