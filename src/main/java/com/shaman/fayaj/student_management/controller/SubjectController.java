package com.shaman.fayaj.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaman.fayaj.student_management.DTO.SubjectDTO;
import com.shaman.fayaj.student_management.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.createSubject(subjectDTO);
    }

    @GetMapping
    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

}