package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> fetchAll();

    Optional<Student> fetchById(Long id);

    Student addStudent(Student student);

    int deleteStudent(Long id);

    int updateStudent(Long id, Student student);
}
