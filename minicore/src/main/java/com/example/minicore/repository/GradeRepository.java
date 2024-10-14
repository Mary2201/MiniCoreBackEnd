package com.example.minicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minicore.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long>{
    
}
