package com.shaman.fayaj.student_management.serviceIMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaman.fayaj.student_management.DTO.StudentDTO;
import com.shaman.fayaj.student_management.DTO.SubjectDTO;
import com.shaman.fayaj.student_management.model.Student;
import com.shaman.fayaj.student_management.repository.StudentRepository;
import com.shaman.fayaj.student_management.repository.SubjectRepository;
import com.shaman.fayaj.student_management.service.StudentService;

@Service

public class studentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setSubjects(
                studentDTO.getSubjects().stream()
                        .map(subjectDTO -> subjectRepository.findById(subjectDTO.getId()).orElseThrow())
                        .collect(Collectors.toSet()));
        student = studentRepository.save(student);
        return convertToDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return convertToDTO(student);
    }

    private StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAddress(student.getAddress());
        dto.setSubjects(
                student.getSubjects().stream()
                        .map(subject -> {
                            SubjectDTO subjectDTO = new SubjectDTO();
                            subjectDTO.setId(subject.getId());
                            subjectDTO.setName(subject.getName());
                            return subjectDTO;
                        })
                        .collect(Collectors.toSet()));
        return dto;
    }

}
