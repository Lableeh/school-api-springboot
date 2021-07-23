package io.javabrains.controller;

import io.javabrains.model.Student;
import io.javabrains.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentServices.getStudents();
    }

    @GetMapping("student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentServices.getStudentById(studentId);
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student) {
        studentServices.addStudent(student);
    }

    @PutMapping("/student/{studentId}")
    public void updateStudent(@RequestBody Student student, @PathVariable int studentId) {
        studentServices.updateStudent(studentId, student);
    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentServices.deleteAdviser(studentId);
    }

}
