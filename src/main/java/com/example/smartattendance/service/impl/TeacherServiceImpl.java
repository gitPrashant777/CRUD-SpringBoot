package com.example.smartattendance.service.impl;

import com.example.smartattendance.dto.TeacherRequest;
import com.example.smartattendance.entity.Department;
import com.example.smartattendance.entity.Teacher;
import com.example.smartattendance.exception.ResourceNotFoundException;
import com.example.smartattendance.repository.DepartmentRepository;
import com.example.smartattendance.repository.TeacherRepository;
import com.example.smartattendance.service.TeacherService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, DepartmentRepository departmentRepository) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
            .orElseThrow(new ResourceNotFoundException("Teacher not found: " + id));
    }

    public Teacher create(TeacherRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(new ResourceNotFoundException("Department not found: " + request.getDepartmentId()));
        Teacher teacher = new Teacher();
        teacher.setEmployeeCode(request.getEmployeeCode());
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setDepartment(department);
        return teacherRepository.save(teacher);
    }

    public Teacher update(Long id, TeacherRequest request) {
        Teacher teacher = findById(id);
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(new ResourceNotFoundException("Department not found: " + request.getDepartmentId()));
        teacher.setEmployeeCode(request.getEmployeeCode());
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setDepartment(department);
        return teacherRepository.save(teacher);
    }

    public void delete(Long id) {
        teacherRepository.delete(findById(id));
    }
}
