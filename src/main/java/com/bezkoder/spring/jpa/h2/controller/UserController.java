package com.bezkoder.spring.jpa.h2.controller;

import com.bezkoder.spring.jpa.h2.model.User;
import com.bezkoder.spring.jpa.h2.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        ResponseEntity<JSONObject> jsonObject = validateBody(user);
        if (jsonObject != null) return jsonObject;
        return ResponseEntity.ok(userService.createUser(user));
    }

    private ResponseEntity<JSONObject> validateBody(User user) {
        JSONObject jsonObject = new JSONObject();
        if (user.getName() == null) {
            jsonObject.put("message", "Name is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        if (user.getAddress() == null) {
            jsonObject.put("message", "Address is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        return null;
    }

    @PostMapping("/addUsers")
    public ResponseEntity<?> addUsers(@RequestBody List<User> users) {
        for (User user :
                users) {
            ResponseEntity<JSONObject> jsonObject = validateBody(user);
            if (jsonObject != null) return jsonObject;
        }
        return ResponseEntity.ok().body(userService.createUsers(users));
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PutMapping("/updateuser")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        ResponseEntity<JSONObject> jsonObject = validateBody(user);
        if (jsonObject != null) return jsonObject;
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
