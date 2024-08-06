package com.shaman.fayaj.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaman.fayaj.student_management.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}