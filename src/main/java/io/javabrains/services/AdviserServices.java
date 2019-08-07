package io.javabrains.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.javabrains.dao.AdviserRepo;
import io.javabrains.dao.SectionRepository;
import io.javabrains.exceptionHandler.AdviserExceptionHandler;
import io.javabrains.model.Adviser;
import io.javabrains.model.Section;

@Service
public class AdviserServices {

	@Autowired
	private AdviserRepo adviserRepo;

	
	public List<Adviser> getAdvisers(){
		return adviserRepo.findAll();
	}
	
	public Adviser getAdviserById(int adviserId) {
//		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
//		if(!adviserID.isPresent()) {
//			throw new AdviserExceptionHandler("AdviserID: "+adviserId+" does not exist !!!");
//		}
			return adviserRepo.findById(adviserId).get();	
	}
	
	public void addAdviser(Adviser adviser) {
//		int adviserId = adviser.getAdviserId();
//		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
//		if(adviserID.isPresent()) {
//			throw new AdviserExceptionHandler("AdviserID: "+adviserId+" already exist !!!");
//		}
		adviserRepo.save(adviser);
	}
	
	public void updateAdviser(int adviserId, Adviser adviser) {
//		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
//		if(!adviserID.isPresent()) {
//			throw new AdviserExceptionHandler("AdviserID: "+adviserId+" does not exist");
//		}
//		adviser.setSection(sections);
//		sections.setAdviser(adviser);
		adviserRepo.save(adviser);
	}
	
	public void deleteAdviser(int adviserId) {
//		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
//		if(!adviserID.isPresent()) {
//			throw new AdviserExceptionHandler("AdviserID: "+adviserId+" does not exist");
//		}
		adviserRepo.deleteById(adviserId);
	}
}
