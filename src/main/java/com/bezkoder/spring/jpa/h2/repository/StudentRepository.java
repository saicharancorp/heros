package com.bezkoder.spring.jpa.h2.repository;


import com.bezkoder.spring.jpa.h2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByFirstName(String firstName);

    List<Student> findByFirstNameLike(String firstName);


}
