package io.javabrains.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ADVISER")
public class Adviser {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adviserId;
	
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int age;
	@Column
	private String gender;
	
	@OneToOne
	@JoinColumn(name="fk_sectionId")
	//@JsonIgnoreProperties("adviser")
	private Section section;
	
	public Adviser() {
		
	}
	
	public Adviser(int adviserId, String firstName, String lastName, int age, String gender) {
		super();
		this.adviserId = adviserId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	
	}
	
	public int getAdviserId() {
		return adviserId;
	}
	public void setAdviserId(int adviserId) {
		this.adviserId = adviserId;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	
	
}
