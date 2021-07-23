package io.javabrains.services;

import io.javabrains.dao.StudentRepository;
import io.javabrains.exception.StudentException;
import io.javabrains.model.Section;
import io.javabrains.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepo.findAll()
            .forEach(students::add);
        return students;
    }

    public Student getStudentById(int studentId) {
        Optional<Student> studentID = studentRepo.findById(studentId);
        if (!studentID.isPresent()) {
            throw new StudentException("StudentID: " + studentId + " does not exist!!!");
        }
        return studentRepo.findById(studentId).get();
    }

    public void addStudent(Student student) {
        int findStudentId = student.getStudentId();
        Optional<Student> studentID = studentRepo.findById(findStudentId);
        if (studentID.isPresent()) {
            throw new StudentException("StudentID: " + findStudentId + " already exist");
        }
        studentRepo.save(student);
    }

    public void updateStudent(int studentId, Student student) {
        Optional<Student> studentID = studentRepo.findById(studentId);
        if (!studentID.isPresent()) {
            throw new StudentException("StudentID " + studentId + " does not exist");
        }
        Student existingStudent = studentRepo.findById(studentId).get();
        Section studentSection = existingStudent.getSection();
        student.setSection(studentSection);
        studentRepo.save(student);
    }

    public void deleteAdviser(int studentId) {
        Optional<Student> studentID = studentRepo.findById(studentId);
        if (!studentID.isPresent()) {
            throw new StudentException("StudentID " + studentId + " does not exist");
        }
        Student existingStudent = studentRepo.findById(studentId).get();
        Section studentSection = existingStudent.getSection();
        if (studentSection != null) {
            studentSection.setStudents(null);
        }
        studentRepo.deleteById(studentId);
    }
}
