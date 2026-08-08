package com.example.smartattendance.service.impl;

import com.example.smartattendance.dto.SectionRequest;
import com.example.smartattendance.entity.Department;
import com.example.smartattendance.entity.Section;
import com.example.smartattendance.exception.ResourceNotFoundException;
import com.example.smartattendance.repository.DepartmentRepository;
import com.example.smartattendance.repository.SectionRepository;
import com.example.smartattendance.service.SectionService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final DepartmentRepository departmentRepository;

    public SectionServiceImpl(SectionRepository sectionRepository, DepartmentRepository departmentRepository) {
        this.sectionRepository = sectionRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section findById(Long id) {
        return sectionRepository.findById(id)
            .orElseThrow(new ResourceNotFoundException("Section not found: " + id));
    }

    public Section create(SectionRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(new ResourceNotFoundException("Department not found: " + request.getDepartmentId()));
        Section section = new Section();
        section.setCode(request.getCode());
        section.setName(request.getName());
        section.setDepartment(department);
        return sectionRepository.save(section);
    }

    public Section update(Long id, SectionRequest request) {
        Section section = findById(id);
        Department department = departmentRepository.findById(request.getDepartmentId())
            .orElseThrow(new ResourceNotFoundException("Department not found: " + request.getDepartmentId()));
        section.setCode(request.getCode());
        section.setName(request.getName());
        section.setDepartment(department);
        return sectionRepository.save(section);
    }

    public void delete(Long id) {
        sectionRepository.delete(findById(id));
    }
}
