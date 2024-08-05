package com.shaman.fayaj.student_management.repository;

import com.shaman.fayaj.student_management.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
