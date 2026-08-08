package com.example.smartattendance.service.impl;

import com.example.smartattendance.dto.DepartmentRequest;
import com.example.smartattendance.entity.Department;
import com.example.smartattendance.exception.ResourceNotFoundException;
import com.example.smartattendance.repository.DepartmentRepository;
import com.example.smartattendance.service.DepartmentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        return departmentRepository.findById(id)
            .orElseThrow(new ResourceNotFoundException("Department not found: " + id));
    }

    public Department create(DepartmentRequest request) {
        Department department = new Department();
        department.setCode(request.getCode());
        department.setName(request.getName());
        return departmentRepository.save(department);
    }

    public Department update(Long id, DepartmentRequest request) {
        Department department = findById(id);
        department.setCode(request.getCode());
        department.setName(request.getName());
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        departmentRepository.delete(findById(id));
    }
}
