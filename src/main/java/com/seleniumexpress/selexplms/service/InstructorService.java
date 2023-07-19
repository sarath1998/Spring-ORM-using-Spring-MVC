package com.seleniumexpress.selexplms.service;

import java.util.List;

import com.seleniumexpress.selexplms.entity.Instructor;

public interface InstructorService 
{
	public List<Instructor> findAllInstructors();

	public void saveInstructor(Instructor instructor);

	public Instructor searchInstructor(int id);

	public void deleteInstructor(int id);
}
