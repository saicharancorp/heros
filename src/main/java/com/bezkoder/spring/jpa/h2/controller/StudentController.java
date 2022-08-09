package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.Student;
import com.bezkoder.spring.jpa.h2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student-jpa")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/say")
	public String sayHello() {
		return "Hello Spring boot";
	}
	
	@GetMapping
	public List<Student> getAll() {
		return studentService.getAll();
	}
	

	@GetMapping("/{rollNo}")
	public Student getStudentById(@PathVariable int rollNo ) {
		return studentService.getStudentById(rollNo);
	}
	
	@GetMapping("/firstName/{firstName}")
	public List<Student> getStudentByName(@PathVariable String firstName ) {
		return studentService.getStudentByFirstName(firstName);
	}

	// get Student by first name (equals())
	@GetMapping("/one-by-firstName/{firstName}")
	public Student getOneStudentByFirstName(@PathVariable String firstName) {
		return studentService.getOneStudentByFirstName(firstName);
	}

	// get Student by first name %LIKE%
	@GetMapping("/firstName-like/{firstName}")
	public List<Student> getStudentByFirstNameLike(@PathVariable String firstName) {
		return studentService.getStudentByFirstNameLike(firstName);
	}

	@GetMapping("/one-by-lastName/{lastName}")
	public Student getStudentBylName(@PathVariable String lastName) {
		return studentService.getStudentByLastName(lastName);
	}


	@GetMapping("/salary-greater-than/{salary}")
	public List<Student> getStudentBySalaryGreaterThan(@PathVariable int salary) {
		return studentService.getStudentBySalaryGreaterThan(salary);
	}
	
	@PostMapping("/get-by-condition")
	public List<Student> getStudentByCondition(@RequestBody Student student) {
		return studentService.getStudentByCondition(student);
	}
}




