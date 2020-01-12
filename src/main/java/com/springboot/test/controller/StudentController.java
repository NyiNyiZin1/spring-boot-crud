package com.springboot.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.test.entity.Student;
import com.springboot.test.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService stuService;
	
	// Get all student
		@GetMapping("/")
		public String getAllStudent(Model model) {
			List<Student> students = stuService.getAllStudents();
			model.addAttribute("students", students);
			return "index";

		}
		
		
		// Add new Student
		@GetMapping("/addstudent")
		public String addNewStudent(Model model) {
			model.addAttribute("newStudent", new Student());
			return "student";
		}

		@PostMapping("/addstudent")
		public String addNewUserPost(@ModelAttribute("student") @Valid Student student) {
			stuService.addNewStudent(student);
			return "redirect:/";
		}
		
//		Get User By Id
		@GetMapping("/{id}")
		public String getStudentById(@PathVariable("id") int id, Model model) {
			Student student = stuService.getStudentById(id);
			model.addAttribute("student", student);
			return "index";
		}
		
		// Update User connect html page connection
	    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	    public String edit(@PathVariable("id") int id, Model model) {
	        model.addAttribute("oldStudent", stuService.getStudentById(id));
	        return "studentupdate";
	    }
	    
	    // Update button click is the event action
	    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	    public String editPost(@ModelAttribute("student") @Valid Student student, @PathVariable("id") int id) {
	    	Student oldStudent = stuService.getStudentById(id);
	    	oldStudent.setStuName(student.getStuName());
	    	oldStudent.setStuPhone(student.getStuPhone());
	    	oldStudent.setStuAddress(student.getStuAddress());
	    	stuService.update(oldStudent);
	        return "redirect:/";
	    }
	    
	    //	Delete Student
		@GetMapping("/remove/{id}")
		public String remoteUser(@PathVariable("id") int id) {
			stuService.removeBtId(id);
			return "redirect:/?success";
		}


}
