package com.student.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.entities.Student;
import com.student.management.repositories.StudentRepository;

@Service
public class StudentServiceImplementation  implements StudentService {

	@Autowired
	StudentRepository repo;
	
	public String addStudent(Student st) {
		repo.save(st);
		return "Student Added";
	}

	
	public Student searchStudent(int roll) {
		return repo.findById(roll).get() ;
	}


	
	public String updateStudent(Student st) {
		repo.save(st);
		return "Student Updated";
	}

	
	public String deleteStudent(int roll) {
		repo.deleteById(roll);
		return "Student Deleted";
	}
	
	public List<Student> fetchAllStudents() {
		return repo.findAll();
		
	}
	

	public String deleteAllStudents() {
		repo.deleteAll();
		return "All Student Deleted";
	}

}
