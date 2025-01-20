package com.example.projectmanagement.service;

import com.example.projectmanagement.dto.StudentDTO;
import com.example.projectmanagement.entity.Student;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    void deleteStudent(Long id);
}
