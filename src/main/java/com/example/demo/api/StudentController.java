package com.example.demo.api;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student person) {
        studentService.updateStudent(id, person);
    }

}
