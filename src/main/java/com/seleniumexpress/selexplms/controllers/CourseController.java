package com.seleniumexpress.selexplms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.selexplms.dto.LessonCountDTO;
import com.seleniumexpress.selexplms.entity.Course;
import com.seleniumexpress.selexplms.entity.Instructor;
import com.seleniumexpress.selexplms.entity.Lesson;
import com.seleniumexpress.selexplms.service.CourseService;
import com.seleniumexpress.selexplms.service.InstructorService;

@SessionAttributes("lessonCountDTO") // Loading this object to session scope.
@Controller
public class CourseController 
{
	@Autowired
	private CourseService courseService;

	@Autowired
	private InstructorService instructorService;

	/**
	 * @param courseId the Course ID
	 * @param model the Model for passing the values from the Java to JSP
	 * @return the Course object i.e the course details for the given course ID
	 */
	@GetMapping("/view-Course")
	public String showCoursePage(@RequestParam("courseId") int courseId,
								 Model model)
	{
		System.out.println("courseId: "+courseId);
		Course course = courseService.findCourseById(courseId);
		model.addAttribute("course", course);

		LessonCountDTO lessonCountDTO = new LessonCountDTO(); 
		List<Lesson> lessons_of_a_course = course.getLessons();
		
		// Ideally, COURSE will have LESSONS.
		// Update the model with the first, last and total lessons count only
		// if there any lessons for a given course.. 
		// Skip any updation to model for a new Emtpy course
		if (!lessons_of_a_course.isEmpty())
		{
			int firstLessonNumber = lessons_of_a_course.get(0).getId();
			System.out.println("################first Lesson Number: "+firstLessonNumber);
			int totalCountOfLessons = course.getLessons().size();
			int lastLessonNumber = (firstLessonNumber + totalCountOfLessons) - 1;
			System.out.println("################Last Lesson Number: "+lastLessonNumber);

			/*
			 * Using a Data Transfer Object instead of actual entity not to showcase the
			 * actual entity object(which is a replica of the DB table)
			 * 
			 * Adding this object to the Model, to make this object available to the JSP
			 * 
			 * Note: We are manually creating the objects for this type of DTO classes, ant not using
			 * any spring beans for this.
			 */
			lessonCountDTO.setFirstLessonNumber(firstLessonNumber);
			lessonCountDTO.setLastLessonNumber(lastLessonNumber);
			lessonCountDTO.setTotalCountOfLessons(totalCountOfLessons);
		}
		model.addAttribute("lessonCountDTO", lessonCountDTO); /* Here the object will be visible only in the course page.. 
																 But as we need this information in the lesson Page as well
															   	 to display the next & previous button, we added the same object
															   	 in the session scope as well in Line no 16	
		 													  */				
		return "course-page";
	}

	/**
	 * Return the complete Lesson details.
	 * @param lessonId the Lesson id
	 * @param model the Model used to transfer the lesson details from Java to JSP
	 * @return the lesson Object i.e the lesson details for the given Lesson id
	 */
	@RequestMapping("/open-lesson")
	public String openLesson(@RequestParam("lessonId") int lessonId,
			Model model)
	{
		System.out.println("lessonId: "+lessonId);
		Lesson lesson = courseService.findLessonById(lessonId);
		model.addAttribute("lesson", lesson);

		return "lesson-page";
	}

	/**
	 * @param model the Model for transferring the data from Java to JSP
	 * @return the empty course object to avoid Null pointer exception and the String
	 * containing the logical name of the view.
	 */
	@GetMapping("/add-course")
	public String showAddCoursePage(Model model)
	{
		model.addAttribute("course", new Course());

		// Fetch all the Instructors and add it to the Model to populate the dropdown
		List<Instructor> allInstructors = instructorService.findAllInstructors();
		model.addAttribute("allInstructors", allInstructors);

		return "add-course";
	}

	/**
	 * Inserts the new course into the Courses table and attaches it to the instructor.
	 * @param model the Model for transferring the data from Java to Jsp
	 */
	@PostMapping("/submit-course")
	public String submitCourse(Course course)
	{
		System.out.println("######Inside the Submit course method #$##############");

		courseService.saveCourse(course);

		return "redirect:/show-Instructors";
	}
}
