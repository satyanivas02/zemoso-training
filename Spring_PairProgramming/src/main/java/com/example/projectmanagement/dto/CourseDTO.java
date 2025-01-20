package com.example.projectmanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String name;
    private List<Long> studentId;
}
