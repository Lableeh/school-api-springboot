package io.javabrains.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.javabrains.dao.AdviserRepo;
import io.javabrains.exception.AdviserException;
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
		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
		if(!adviserID.isPresent()) {
			throw new AdviserException("AdviserID: "+adviserId+" does not exist !!!");
		}
			return adviserRepo.findById(adviserId).get();	
	}
	
	public void addAdviser(Adviser adviser) {
		int adviserId = adviser.getAdviserId();
		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
		if(adviserID.isPresent()) {
			throw new AdviserException("AdviserID: "+adviserId+" already exist !!!");
		}
		adviserRepo.save(adviser);
	}
	
	public void updateAdviser(int adviserId, Adviser adviser) {
		Optional<Adviser> adviserID = adviserRepo.findById(adviserId);
		if(!adviserID.isPresent()) {
			throw new AdviserException("AdviserID: "+adviserId+" does not exist");
		}
		//adviser.setSection(sections);
		//sections.setAdviser(adviser);
		Adviser existingAdviser = adviserRepo.findById(adviserId).get();
		Section adviserSec = existingAdviser.getSection();
		adviser.setSection(adviserSec);
		adviserRepo.save(adviser);
	}
	
	public void deleteAdviser(int adviserId) {
		Optional<Adviser> adviser = adviserRepo.findById(adviserId);
		if(!adviser.isPresent()) {
			throw new AdviserException("AdviserID: "+adviserId+" does not exist");
		}
		//Adviser existingAdviser = adviserRepo.findById(adviserId).get();
		Section adviserSection = adviser.get().getSection();
		if(adviserSection != null) {
			adviserSection.setAdviser(null);
		}
		adviserRepo.deleteById(adviserId);
		
	}
}
