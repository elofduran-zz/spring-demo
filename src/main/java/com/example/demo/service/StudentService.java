package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public List<Student> getStudents() {
        return studentRepository.fetchAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.fetchById(id);
    }

    public int deleteStudent(Long id) {
        return studentRepository.deleteStudent(id);
    }

    public int updateStudent(Long id, Student student) {
        return studentRepository.updateStudent(id, student);
    }
}
