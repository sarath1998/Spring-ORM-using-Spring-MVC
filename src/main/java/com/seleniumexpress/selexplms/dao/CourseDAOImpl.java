package com.seleniumexpress.selexplms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	/**
	 * Fetch the Course details for the given course ID.
	 */
	@Transactional
	@Override
	public Course findCourseById(int courseId) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(Course.class, courseId);
	}

	/**
	 * Fetch the Lesson details for the given lesson ID.
	 */
	@Transactional
	@Override
	public Lesson findLessonById(int lessonId) 
	{
		Session session = sessionFactory.getCurrentSession();
		return session.get(Lesson.class, lessonId);
	}

	@Override
	@Transactional
	public void saveCourse(Course course) 
	{
		Session session = sessionFactory.getCurrentSession();
		session.persist(course);
	}

}
