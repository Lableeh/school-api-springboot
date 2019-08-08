package io.javabrains.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.dao.AdviserRepo;
import io.javabrains.dao.SectionRepository;
import io.javabrains.dao.StudentRepository;
import io.javabrains.exception.SectionException;
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
		Optional<Section> sectionID = sectionRepo.findById(sectionId);
		if(!sectionID.isPresent()) {
			throw new SectionException("SectionID: "+sectionId+" does not exist!!!");
		}
		return sectionRepo.findById(sectionId).get();
	}

	public void addSection(Section section) {
		int sectionId = section.getSectionId();
		Optional<Section> sectionID = sectionRepo.findById(sectionId);
		if(sectionID.isPresent()) {
			throw new SectionException("SectionID "+sectionId+" already exist!!!");
		}
		sectionRepo.save(section);
	}

	public void updateSection(int sectionId,Section section) {
		Optional<Section> sectionID = sectionRepo.findById(sectionId);
		if(!sectionID.isPresent()) {
			throw new SectionException("SectionID: "+sectionId+" does not exist!!!");
		}
		Section existingSection = sectionRepo.findById(sectionId).get();
		Adviser sectionAdviser = existingSection.getAdviser();
		section.setAdviser(sectionAdviser);
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
