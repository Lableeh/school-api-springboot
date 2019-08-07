package io.javabrains.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.javabrains.model.Student;
import io.javabrains.services.StudentServices;

@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge = 3600)
@RestController
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("/student")
	public List<Student> getStudents(){
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
	
//	@PutMapping("section/{sectionId}/student")
//	public void addStudentToSection(@RequestBody SectionRequest request,@PathVariable int sectionId) {
//		studentServices.addStudentToSection(student,sectionId);
//	}
	
	@PutMapping("/student/{studentId}")
	public void updateStudent(@RequestBody Student student,@PathVariable int studentId) {
		studentServices.updateStudent(studentId, student);
	}
	
	@DeleteMapping("/student/{studentId}")
	public void deleteStudent(@PathVariable int studentId) {
		studentServices.deleteAdviser(studentId);
	}

}
