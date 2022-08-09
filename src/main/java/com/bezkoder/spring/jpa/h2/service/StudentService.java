package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.model.Student;

import java.util.List;


public interface StudentService {
	
	List<Student> getAllStudent();
	Student getStudentById(Long id);
	Student saveStudent(Student student);
	String deleteStudent(Long id);
	Student updateStudent(Long id, Student student);
	

}
