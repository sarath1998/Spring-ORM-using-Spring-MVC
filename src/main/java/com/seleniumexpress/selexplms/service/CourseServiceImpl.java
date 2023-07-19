package com.seleniumexpress.selexplms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.selexplms.dao.CourseDAO;
import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDao;
	
	@Override
	public Course findCourseById(int courseId) 
	{
		return courseDao.findCourseById(courseId);
	}

	@Override
	public Lesson findLessonById(int lessonId) 
	{
		return courseDao.findLessonById(lessonId);
	}

	@Override
	public void saveCourse(Course course) {
		
		courseDao.saveCourse(course);
	}

}
