package com.student.management.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.entities.Student;
import com.student.management.services.StudentService;



@Controller
public class StudentController {
	
	
//------------------Project Start-----------------------------	
	@Autowired
	StudentService service;
	
	//@RequestBody - @ModelAttribute
	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute Student st,Model model) {
		String stu = service.addStudent(st);
		model.addAttribute("msg","Student Added Successfully");
		return "index";
		
	}
	// Retrive Data From DataBase
	/*
	@GetMapping("/searchStudent")
	public Student searchStudent(@RequestParam int roll) {
		return service.searchStudent(roll);
	}
	*/
	//Changing Search Student for getting data in frontend
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam int roll,Model model) {
			Student st = service.searchStudent(roll);
			model.addAttribute("student", st);
			return "displayStudent";
	}
	
	// Update Data to DataBase // PUT --POST
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student st) {
		service.updateStudent(st);
		return "index";
			
	}
	
	//DeleteMapping - GetMapping
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int roll) {
		service.deleteStudent(roll);
		return "index";
	}
	
	//Get all details of Student
	@GetMapping("/fetchAllStudents")
	public String fetchAllStudents(Model model){
		List<Student> sList = service.fetchAllStudents();
		model.addAttribute("studentList", sList);
		return "displayAllStudents";
	}
	
	@GetMapping("/deleteAllStudents")
	public String deleteAllStudents(){
		service.deleteAllStudents();
		return "index";
	}
	

}
