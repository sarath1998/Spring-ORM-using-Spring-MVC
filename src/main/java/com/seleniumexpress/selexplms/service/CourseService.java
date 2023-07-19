package com.seleniumexpress.selexplms.service;

import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Lesson;

public interface CourseService {
	
	public Course findCourseById(int courseId);

	public Lesson findLessonById(int lessonId);

	public void saveCourse(Course course);

}
