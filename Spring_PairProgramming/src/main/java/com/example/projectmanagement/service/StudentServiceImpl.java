package com.example.projectmanagement.service;

import com.example.projectmanagement.dto.StudentDTO;
import com.example.projectmanagement.entity.Course;
import com.example.projectmanagement.entity.Student;
import com.example.projectmanagement.exception.ResourceNotFoundException;
import com.example.projectmanagement.repository.CourseRepository;
import com.example.projectmanagement.repository.StudentRepository;
import com.example.projectmanagement.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Course course = courseRepository.findById(studentDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + studentDTO.getCourseId()));
        Student student = modelMapper.map(studentDTO, Student.class);
        student.setCourse(course);
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDTO.class);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        Course course = courseRepository.findById(studentDTO.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + studentDTO.getCourseId()));
        student.setName(studentDTO.getName());
        student.setCourse(course);
        Student updatedStudent = studentRepository.save(student);
        return modelMapper.map(updatedStudent, StudentDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        studentRepository.delete(student);
    }
}
