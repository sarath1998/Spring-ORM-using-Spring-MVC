package com.seleniumexpress.selexplms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.seleniumexpress.selexplms.dto.SearchDTO;
import com.seleniumexpress.selexplms.entity.Instructor;
import com.seleniumexpress.selexplms.service.InstructorService;

@Controller
public class InstructorController implements WebMvcConfigurer {

	@Autowired
	private InstructorService instructorService;
	
	
	@RequestMapping("/show-Instructors")
	public String showInstructorHomePage(Model model)
	{
		List<Instructor> instructorsList = instructorService.findAllInstructors();
		
		model.addAttribute("instructorList", instructorsList);
		model.addAttribute("searchDTO", new SearchDTO());
		System.out.println(instructorsList);
		return "instructor-home";
	}
	
	@RequestMapping("/add-instructor")
	public String showInsertInstructorPage(Model model)
	{
		model.addAttribute("instructor", new Instructor());  /* Since we use the Spring MVC Form tags, 
	       													    in the add-Instructor.jsp, there fore we need to 
	                                                            initialize as the spring expects
	                                                            the object to be present for the class mentioned in the modelAttribute
	                                                          */ 
		return "add-Instructor";
	}
	
	@PostMapping("/submit-instructor")
	public String saveInstructor(Instructor instructor)
	{
		System.out.println("Submit instructor: "+instructor);
		instructorService.saveInstructor(instructor);
		return "redirect:/show-Instructors";
	}
	
	/**
	 * @param id the Instructor Id
	 * @param model the Model
	 * @return the Instructor Details for the given id in the search bar
	 */
	@RequestMapping("/process-search")
	public String searchInstructor(@RequestParam("id") int id,
								   Model model)
	{
		ArrayList<Instructor> instructors = new ArrayList<>();
		Instructor searchInstructor = instructorService.searchInstructor(id);
		instructors.add(searchInstructor);
		
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setId(id); // set the search ID
		
		model.addAttribute("instructorList", instructors);
		model.addAttribute("searchDTO", searchDTO); // Dummy searchDTO to avoid Null Pointer exception
		return "instructor-home";
	}
	
	/**
	 * @param id the Instructor Id
	 * @param model the Model
	 * @return the Instructor Details for the given id in the search bar
	 */
	@RequestMapping("/delete-Instructor")
	public String deleteInstructor(@RequestParam("id") int id)
	{
		instructorService.deleteInstructor(id);
		return "redirect:/show-Instructors";
	}
}
