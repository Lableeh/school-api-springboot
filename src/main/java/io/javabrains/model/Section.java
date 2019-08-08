package io.javabrains.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.javabrains.model.Adviser;


@Entity
@Table (name = "SECTION")
public class Section {
	
	@Id
	private int sectionId;
	
	@Column
	private String sectionName;
	
	@OneToOne(mappedBy="section",fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("section")
	private Adviser adviser;
	
	@OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("section")
	private List<Student> students;
		
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	public Adviser getAdviser() {
		return adviser;
	}
	
	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void setStudents(List<Student> student) {
		this.students = student;
	}
	
}
