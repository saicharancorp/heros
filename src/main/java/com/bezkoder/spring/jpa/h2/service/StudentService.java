package com.bezkoder.spring.jpa.h2.service;


import com.bezkoder.spring.jpa.h2.model.Student;

import java.util.List;


public interface StudentService {
	
	List<Student> getAll();

	List<Student> getStudentByFirstName(String firstName);

	Student getOneStudentByFirstName(String firstName);

	List<Student> getStudentByFirstNameLike(String firstName);

	Student getStudentById(int empId);
	
	Student getStudentByLastName(String lastName);

	List<Student> getStudentBySalaryGreaterThan(int salary);
	
	List<Student> getStudentByCondition(Student student);

}
