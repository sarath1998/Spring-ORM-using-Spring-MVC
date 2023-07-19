package com.seleniumexpress.selexplms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.selexplms.dao.InstructorDAO;
import com.seleniumexpress.selexplms.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDao;
	
	@Transactional
	@Override
	public List<Instructor> findAllInstructors() {
		return instructorDao.findAllInstructors();
	}
	
	@Transactional
	@Override
	public void saveInstructor(Instructor instructor) {
		instructorDao.saveInstructor(instructor);

	}

	@Override
	public Instructor searchInstructor(int id) {
		return instructorDao.findInstructor(id);
		
	}

	@Override
	public void deleteInstructor(int id) {
		instructorDao.deleteInstructor(id);
		
	}

}
