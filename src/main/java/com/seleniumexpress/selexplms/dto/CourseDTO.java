package com.seleniumexpress.selexplms.dto;

public class CourseDTO {
	
	private int id;
	private String courseName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", courseName=" + courseName + "]";
	}
	
	
	

}
