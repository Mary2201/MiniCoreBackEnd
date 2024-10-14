package com.example.minicore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.minicore.model.Subject;
import com.example.minicore.repository.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // Obtener todas las materias
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
