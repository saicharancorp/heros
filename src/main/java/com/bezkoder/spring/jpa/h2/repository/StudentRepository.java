package com.bezkoder.spring.jpa.h2.repository;

import com.bezkoder.spring.jpa.h2.model.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Long> {

}
