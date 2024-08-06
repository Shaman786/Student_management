
package com.shaman.fayaj.student_management.service;

import java.util.List;

import com.shaman.fayaj.student_management.DTO.StudentDTO;

public interface StudentService {
    public StudentDTO createStudent(StudentDTO studentDTO);

    public List<StudentDTO> getAllStudents();

    public StudentDTO getStudentById(Long id);
}