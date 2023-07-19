package com.seleniumexpress.selexplms.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Instructors")
public class Instructor {

	//instructor_id, instructor_name, instructor_training_exp, instructor_email
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;
	
	@Column(name = "instructor_name")
	private String name;
	
	@Column(name = "instructor_training_exp")
	private int teachingExp;
	
	@Column(name = "instructor_email")
	private String email;
	
	@OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
	private List<Course> courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeachingExp() {
		return teachingExp;
	}

	public void setTeachingExp(int teachingExp) {
		this.teachingExp = teachingExp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", teachingExp=" + teachingExp + ", email=" + email + "]";
	}
}
