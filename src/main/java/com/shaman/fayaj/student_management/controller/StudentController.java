package com.shaman.fayaj.student_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaman.fayaj.student_management.DTO.StudentDTO;
import com.shaman.fayaj.student_management.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {

        return studentService.createStudent(studentDTO);

    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);
    }

}