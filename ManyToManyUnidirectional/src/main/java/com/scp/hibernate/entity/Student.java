package com.scp.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
		
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="STUD_ID")
	private int id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Student_Subject" , joinColumns= {@JoinColumn(name="STUD_ID")} , inverseJoinColumns= {@JoinColumn(name="SUBJECT_ID")})
	private List<Subjects> subjects = new ArrayList<Subjects>();

	
	public Student() {
	
	}
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", subjects=" + subjects
				+ "]";
	}
	
	


}
