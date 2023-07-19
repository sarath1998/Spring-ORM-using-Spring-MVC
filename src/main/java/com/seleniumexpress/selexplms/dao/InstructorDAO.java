package com.seleniumexpress.selexplms.dao;

import java.util.List;

import com.seleniumexpress.selexplms.entity.Instructor;

public interface InstructorDAO {
	
	public List<Instructor> findAllInstructors();

	public void saveInstructor(Instructor instructor);

	public Instructor findInstructor(int id);

	public void deleteInstructor(int id);

}
