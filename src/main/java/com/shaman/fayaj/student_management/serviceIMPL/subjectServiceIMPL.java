package com.shaman.fayaj.student_management.serviceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaman.fayaj.student_management.DTO.SubjectDTO;
import com.shaman.fayaj.student_management.model.Subject;
import com.shaman.fayaj.student_management.repository.SubjectRepository;
import com.shaman.fayaj.student_management.service.SubjectService;

@Service
public class subjectServiceIMPL implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());
        subject = subjectRepository.save(subject);
        return convertToDTO(subject);
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SubjectDTO convertToDTO(Subject subject) {
        SubjectDTO dto = new SubjectDTO();
        dto.setId(subject.getId());
        dto.setName(subject.getName());
        return dto;
    }
}
