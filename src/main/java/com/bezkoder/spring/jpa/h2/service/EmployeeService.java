package com.bezkoder.spring.jpa.h2.service;


import com.bezkoder.spring.jpa.h2.model.emp.Employee;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface EmployeeService {

    List<?> findAll();

    Employee findById(int id) throws ChangeSetPersister.NotFoundException;

    Employee save(Employee superHero);

	Employee update(int id, Employee employee) throws ChangeSetPersister.NotFoundException;

    void delete(int id);

}
