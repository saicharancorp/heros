package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.Student;
import com.bezkoder.spring.jpa.h2.service.StudentService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        ResponseEntity<JSONObject> jsonObject = validateJSON(student);
        if (jsonObject != null) return jsonObject;
        return ResponseEntity.ok().
                body(studentService.saveStudent(student));
    }

    private ResponseEntity<JSONObject> validateJSON(Student student) {
        JSONObject jsonObject = new JSONObject();
        if (student.getName() == null) {
            jsonObject.put("message", "Name is required");
            return ResponseEntity.badRequest()
                    .body(jsonObject);
        }

        if (student.getAge() == null) {
            jsonObject.put("message", "Age is required");
            return ResponseEntity.badRequest()
                    .body(jsonObject);
        }
        if (student.getEmail() == null) {
            jsonObject.put("message", "Email is required");
            return ResponseEntity.badRequest()
                    .body(jsonObject);
        }
        return null;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        ResponseEntity<JSONObject> jsonObject = validateJSON(student);
        if (jsonObject != null) return jsonObject;
        return ResponseEntity.ok().
                body( studentService.updateStudent(id, student));
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        return studentService.deleteStudent(id);
    }

}
