package com.example.minicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minicore.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
    
}
