package io.javabrains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.dao.AdviserRepo;
import io.javabrains.dao.SectionRepository;
import io.javabrains.dao.StudentRepository;
import io.javabrains.model.Adviser;
import io.javabrains.model.Section;
import io.javabrains.model.SectionRequest;
import io.javabrains.model.Student;

@Service
public class SectionServices {

	@Autowired
	private SectionRepository sectionRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private AdviserRepo adviserRepo;

	public List<Section> getAllSection() {
		List<Section> sections = sectionRepo.findAll();
		return sections;
	}

	public Section getSectionById(int sectionId) {
		return sectionRepo.findById(sectionId).get();
	}

	public void addSection(Section section) {
		sectionRepo.save(section);
	}

	public void updateSection(Section section) {
		sectionRepo.save(section);
	}

	public void addStudentsToSection(SectionRequest request, int sectionId) {
		Section section = sectionRepo.findById(sectionId).get();
		List<Integer> studentIdList = request.getAdditionalStudents();
		List<Student> students = section.getStudents();
		for (Integer e : studentIdList) {
			Student student = studentRepo.findById(e).get();
			students.add(student);
			student.setSection(section);
			section.setStudents(students);
		}
		sectionRepo.save(section);
	}
	
	public void deleteStudentsToSection(SectionRequest requestDelete,int sectionId) {
		Section section = sectionRepo.findById(sectionId).get();
		List<Integer> studentIdListToDelete = requestDelete.getDeleteStudents();
		for(Integer e : studentIdListToDelete) {
			studentRepo.deleteById(e);
		}
		sectionRepo.save(section);
	}

	public void addAdviserToSection(SectionRequest request, int sectionId) {
		Section section = sectionRepo.findById(sectionId).get();
		int newAdviser = request.getAdditionalAdviser();
		Adviser adviser = adviserRepo.findById(newAdviser).get();
		adviser.setSection(section);
		section.setAdviser(adviser);
		sectionRepo.save(section);
	}

	public void deleteSection(int sectionId) {
		sectionRepo.deleteById(sectionId);
	}

}
