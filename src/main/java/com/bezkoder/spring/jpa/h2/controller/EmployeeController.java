package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.emp.Employee;
import com.bezkoder.spring.jpa.h2.service.EmployeeService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) throws ChangeSetPersister.NotFoundException {
        Employee employee = service.findById(id);
        return ResponseEntity.ok().body(employee);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Employee employee) {
//        return ResponseEntity.ok().body(savedEmployee);
        ResponseEntity<JSONObject> jsonObject = validateBody(employee);
        if (jsonObject != null) return jsonObject;
        Employee savedEmployee = service.save(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEmployee);
    }

    private ResponseEntity<JSONObject> validateBody(Employee employee) {
        JSONObject jsonObject = new JSONObject();
        if (employee.getFirstName() == null) {
            jsonObject.put("message", "First Name is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        if (employee.getLastName() == null) {
            jsonObject.put("message", "Last Name is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        if (employee.getPhoneNumbers() == null) {
            jsonObject.put("message", "Phone Number is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        if (employee.getAddress() == null) {
            jsonObject.put("message", "Address is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        return null;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Employee employee) {
        ResponseEntity<JSONObject> jsonObject = validateBody(employee);
        if (jsonObject != null) return jsonObject;
        Employee updatedEmployee = null;
        try {
            updatedEmployee = service.update(id, employee);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().body(updatedEmployee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}

