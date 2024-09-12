package com.student.management.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class NavigationController {
	@GetMapping("/openAddStudentPage")
	public String openAddStudentPage() {
		return "addStudent";
	}
	
	@GetMapping("/openUpdateStudentPage")
	public String openUpdateStudentPage() {
		return "updateStudent";
	}

	@GetMapping("/openDeleteStudentPage")
	public String openDeleteStudentPage() {
		return "deleteStudent";
	}
	
//	@GetMapping("/openDeleteAllStudentPage")
//	public String openDeleteAllStudentPage() {
//		return "deleteAllStudent";
//	}
	
	@GetMapping("/openSearchStudentPage")
	public String openSearchStudentPage() {
		return "searchStudent";
	}
}
