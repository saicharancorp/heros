package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.Student;
import com.bezkoder.spring.jpa.h2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
	 	return studentService.getAllStudent();
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		return studentService.deleteStudent(id);
	}

}
