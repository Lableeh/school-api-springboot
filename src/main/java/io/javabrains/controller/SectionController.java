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
import io.javabrains.model.Section;
import io.javabrains.model.SectionRequest;
import io.javabrains.services.SectionServices;


@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge = 3600)
@RestController
public class SectionController {
	
	@Autowired
	private SectionServices sectionServices;
	
	@GetMapping("/section")
	public List<Section> getAllSections(){
		return sectionServices.getAllSection();
	}
	
	@GetMapping("/section/{sectionId}")
	public Section getSectionById(@PathVariable int sectionId) {
		return sectionServices.getSectionById(sectionId);
	}
	
	@PostMapping("/section")
	public void addSection(@RequestBody Section section) {
		sectionServices.addSection(section);
	}
	
	
	@PutMapping("/section/{sectionId}/student")
	public void addStudentsToSection(@RequestBody SectionRequest request,@PathVariable int sectionId) {
		sectionServices.addStudentsToSection(request, sectionId);
	}
	
	@PutMapping("/section/{sectionId}/adviser")
	public void addAdviserToSection(@RequestBody SectionRequest request,@PathVariable int sectionId) {
		sectionServices.addAdviserToSection(request, sectionId);
	}
		
	@PutMapping("/section/{sectionId}")
	public void updateSection(@RequestBody Section section ,@PathVariable int sectionId) {
		sectionServices.updateSection(sectionId, section);
	}
	
	@DeleteMapping("section/{sectionId}")
	public void deleteSection(@PathVariable int sectionId) {
		sectionServices.deleteSection(sectionId);
	}
	
	@PutMapping("section/{sectionId}/student/delete")
	public void deleteStudentsToSection(@RequestBody SectionRequest request,@PathVariable int sectionId) {
		sectionServices.deleteStudentsToSection(request, sectionId);
	}
	
}
