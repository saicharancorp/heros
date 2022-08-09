package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.model.Student;

import java.util.List;



public interface EmployeeQueryService {
	
	List<Student> getAll();

	List<Student> getEmployeeByFirstName(String firstName);

	Student getSingleEmployeeByLastName(String lastName);

	List<Student> getEmployeeByFirstNameLike(String firstName);

	Student getOneEmployeeByFirstName(String firstName);

	List<Student> getEmployeeBySalaryGreaterThan(int salary);

	List<Student> getEmployeeByCondition(Student student);


}
