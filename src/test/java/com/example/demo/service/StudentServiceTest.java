package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void testAddStudent() {
        Student student = new Student(1L, "test student");
        when(studentRepository.addStudent(student)).thenReturn(student);
        assertEquals(student, studentService.addStudent(student));
    }

    @Test
    public void testGetStudents() {
        Student student1 = new Student(1L, "test student");
        Student student2 = new Student(2L, "test student");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        when(studentRepository.addStudent(student1)).thenReturn(student1);
        when(studentRepository.addStudent(student2)).thenReturn(student2);
        when(studentRepository.fetchAll()).thenReturn(students);
        assertEquals(students, studentService.getStudents());
    }

    @Test
    public void testGetStudentById() {
        Student student = new Student(1L, "test student");
        when(studentRepository.addStudent(student)).thenReturn(student);
        when(studentRepository.fetchById(1L)).thenReturn(java.util.Optional.of(student));
        assertEquals(java.util.Optional.of(student), studentService.getStudentById(1L));
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student(1L, "test student");
        when(studentRepository.addStudent(student)).thenReturn(student);
        when(studentRepository.deleteStudent(1L)).thenReturn(1);
        assertEquals(1, studentService.deleteStudent(1L));
    }

    @Test
    public void testUpdateStudent() {
        Student old_student = new Student(1L, "test student");
        Student new_student = new Student(old_student.getId(), "new test student");
        when(studentRepository.updateStudent(1L, new_student)).thenReturn(1);
        assertEquals(1, studentService.updateStudent(old_student.getId(), new_student));
    }
}