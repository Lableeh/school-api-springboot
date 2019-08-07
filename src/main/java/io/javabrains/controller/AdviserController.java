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
import io.javabrains.model.Adviser;
import io.javabrains.services.AdviserServices;

@CrossOrigin(origins = "*", allowedHeaders = "*",maxAge = 3600)
@RestController
public class AdviserController {

	@Autowired
	private AdviserServices adviserServices;
	
	@GetMapping("/adviser")
	public List<Adviser> getAdvisers(){
		return adviserServices.getAdvisers();
	}
	
	@GetMapping("adviser/{adviserId}")
	public Adviser getAdviserById(@PathVariable int adviserId) {
		return adviserServices.getAdviserById(adviserId);
	}
	
	@PostMapping("/adviser")
	public void addAdviser(@RequestBody Adviser adviser) {
		adviserServices.addAdviser(adviser);
	}
	
	@PutMapping("/adviser/{adviserId}")
	public void updateAdviser(@RequestBody Adviser adviser,@PathVariable int adviserId) {
		adviserServices.updateAdviser(adviserId, adviser);
	}
	
	@DeleteMapping("/adviser/{adviserId}")
	public void deleteAdviser(@PathVariable int adviserId) {
		adviserServices.deleteAdviser(adviserId);
	}
	
}
