package io.javabrains.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.javabrains.dao.StudentRepository;
import io.javabrains.model.Student;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		studentRepo.findAll()
		.forEach(students::add);
		return students;
	}
	
	public Student getStudentById(int studentId) {
		return studentRepo.findById(studentId).get();
	}
	
	public void addStudent(Student student) {
		studentRepo.save(student);
	}
	
	public void updateStudent(int studentId,Student student) {
		studentRepo.save(student);
	}
	
	public void deleteAdviser(int studentId) {
		studentRepo.deleteById(studentId);
	}
}
