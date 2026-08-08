package com.example.smartattendance.service.impl;

import com.example.smartattendance.dto.LectureRequest;
import com.example.smartattendance.entity.Lecture;
import com.example.smartattendance.entity.Section;
import com.example.smartattendance.entity.Teacher;
import com.example.smartattendance.exception.ResourceNotFoundException;
import com.example.smartattendance.repository.LectureRepository;
import com.example.smartattendance.repository.SectionRepository;
import com.example.smartattendance.repository.TeacherRepository;
import com.example.smartattendance.service.LectureService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final TeacherRepository teacherRepository;
    private final SectionRepository sectionRepository;

    public LectureServiceImpl(LectureRepository lectureRepository, TeacherRepository teacherRepository, SectionRepository sectionRepository) {
        this.lectureRepository = lectureRepository;
        this.teacherRepository = teacherRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    public Lecture findById(Long id) {
        return lectureRepository.findById(id)
            .orElseThrow(new ResourceNotFoundException("Lecture not found: " + id));
    }

    public Lecture create(LectureRequest request) {
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
            .orElseThrow(new ResourceNotFoundException("Teacher not found: " + request.getTeacherId()));
        Section section = sectionRepository.findById(request.getSectionId())
            .orElseThrow(new ResourceNotFoundException("Section not found: " + request.getSectionId()));
        Lecture lecture = new Lecture();
        lecture.setTitle(request.getTitle());
        lecture.setStartsAt(request.getStartsAt());
        lecture.setEndsAt(request.getEndsAt());
        lecture.setTeacher(teacher);
        lecture.setSection(section);
        return lectureRepository.save(lecture);
    }

    public Lecture update(Long id, LectureRequest request) {
        Lecture lecture = findById(id);
        Teacher teacher = teacherRepository.findById(request.getTeacherId())
            .orElseThrow(new ResourceNotFoundException("Teacher not found: " + request.getTeacherId()));
        Section section = sectionRepository.findById(request.getSectionId())
            .orElseThrow(new ResourceNotFoundException("Section not found: " + request.getSectionId()));
        lecture.setTitle(request.getTitle());
        lecture.setStartsAt(request.getStartsAt());
        lecture.setEndsAt(request.getEndsAt());
        lecture.setTeacher(teacher);
        lecture.setSection(section);
        return lectureRepository.save(lecture);
    }

    public void delete(Long id) {
        lectureRepository.delete(findById(id));
    }
}
