package com.bezkoder.spring.jpa.h2.service.impl;

import com.bezkoder.spring.jpa.h2.model.emp.Employee;
import com.bezkoder.spring.jpa.h2.repository.EmployeeRepository;
import com.bezkoder.spring.jpa.h2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee update(int id, Employee employee) throws ChangeSetPersister.NotFoundException {
    	repository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        
    	employee.setId(id);
    	return repository.save(employee);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Employee -> repository.delete(Employee));
    }
}
