package com.example.minicore.dto;

import lombok.Data;

@Data
public class GradeDTO {

    private Long studentId;
    private Long subjectId;
    private Double grade;
}