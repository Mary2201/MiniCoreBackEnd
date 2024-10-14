package com.example.minicore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minicore.dto.GradeDTO;
import com.example.minicore.model.Grade;
import com.example.minicore.model.Student;
import com.example.minicore.model.Subject;
import com.example.minicore.repository.GradeRepository;
import com.example.minicore.repository.StudentRepository;
import com.example.minicore.repository.SubjectRepository;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    // Crear una nueva calificación
    public Grade saveGrade(GradeDTO gradeDTO) {
        Student student = studentRepository.findById(gradeDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Subject subject = subjectRepository.findById(gradeDTO.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setGrade(gradeDTO.getGrade());

        return gradeRepository.save(grade);
    }

    // Obtener todas las calificaciones
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    // Obtener calificación por ID
    public Grade getGradeById(Long id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
    }

    // Actualizar una calificación existente
    public Grade updateGrade(Long id, GradeDTO gradeDTO) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));

        Student student = studentRepository.findById(gradeDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Subject subject = subjectRepository.findById(gradeDTO.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setGrade(gradeDTO.getGrade());

        return gradeRepository.save(grade);
    }

    // Eliminar una calificación por ID
    public void deleteGrade(Long id) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
        gradeRepository.delete(grade);
    }
}

