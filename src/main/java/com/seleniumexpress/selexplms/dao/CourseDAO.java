package com.seleniumexpress.selexplms.dao;

import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

public interface CourseDAO {

	public Course findCourseById(int courseId);

	public Lesson findLessonById(int lessonId);

	public void saveCourse(Course course);
	
}
