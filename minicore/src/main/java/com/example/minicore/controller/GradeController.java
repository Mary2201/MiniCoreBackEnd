package com.example.minicore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.minicore.dto.GradeDTO;
import com.example.minicore.model.Grade;
import com.example.minicore.service.GradeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    // Crear una nueva calificación
    @PostMapping
    public ResponseEntity<Grade> createGrade(@RequestBody GradeDTO gradeDTO) {
        Grade grade = gradeService.saveGrade(gradeDTO);
        return new ResponseEntity<>(grade, HttpStatus.CREATED);
    }

    // Obtener todas las calificaciones
    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return new ResponseEntity<>(grades, HttpStatus.OK);
    }

    // Obtener una calificación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Grade grade = gradeService.getGradeById(id);
        return new ResponseEntity<>(grade, HttpStatus.OK);
    }

    // Actualizar una calificación existente
    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        Grade updatedGrade = gradeService.updateGrade(id, gradeDTO);
        return new ResponseEntity<>(updatedGrade, HttpStatus.OK);
    }

    // Eliminar una calificación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

