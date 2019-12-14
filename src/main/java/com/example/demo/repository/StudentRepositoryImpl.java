package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static List<Student> students = new ArrayList<>();

    @Override
    public List<Student> fetchAll() {
        return students;
    }

    @Override
    public Optional<Student> fetchById(Long id) {
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        return student;
    }

    @Override
    public int addStudent(Student student) {
        students.add(student);
        return 1;
    }

    @Override
    public int deleteStudent(Long id) {
        Optional<Student> student = fetchById(id);

        if (!student.isPresent())
            return 0;

        students.remove(student.get());
        return 1;
    }

    @Override
    public int updateStudent(Long id, Student student) {

        return fetchById(id)
                .map(p -> {
                    int indexStudentToDelete = students.indexOf(student);
                    if (indexStudentToDelete >= 0 ) {
                        students.set(indexStudentToDelete, student);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
