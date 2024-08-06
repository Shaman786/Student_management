package com.shaman.fayaj.student_management.service;

import java.util.List;

import com.shaman.fayaj.student_management.DTO.SubjectDTO;

public interface SubjectService {
    public SubjectDTO createSubject(SubjectDTO subjectDTO);

    public List<SubjectDTO> getAllSubjects();
}
