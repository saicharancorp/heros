package com.bezkoder.spring.jpa.h2.controller;


import com.bezkoder.spring.jpa.h2.model.SuperHero;
import com.bezkoder.spring.jpa.h2.service.SuperHeroService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/heroes")
public class SuperHeroController {

    @Autowired
    private SuperHeroService superHeroService;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = superHeroService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        SuperHero superHero = superHeroService.findById(id);
        return ResponseEntity.ok().body(superHero);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody SuperHero superHero) {

        ResponseEntity<JSONObject> jsonObject = validateBody(superHero);
        if (jsonObject != null) return jsonObject;


        SuperHero savedSuperHero = superHeroService.save(superHero);

//        return ResponseEntity.ok().body(savedSuperHero);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedSuperHero.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedSuperHero);
    }

    private ResponseEntity<JSONObject> validateBody(SuperHero superHero) {
        JSONObject jsonObject = new JSONObject();
        if (superHero.getSuperName() == null) {
            jsonObject.put("message", "Super Name is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }

        if (superHero.getName() == null) {
            jsonObject.put("message", "Name is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }

        if (superHero.getAge() == 0) {
            jsonObject.put("message", "Age is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }

        if (superHero.getProfession() == null) {
            jsonObject.put("message", "Profession is required");
            return ResponseEntity.badRequest().body(jsonObject);
        }
        return null;
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody SuperHero superHero) {
        ResponseEntity<JSONObject> jsonObject = validateBody(superHero);
        if (jsonObject != null) return jsonObject;
        SuperHero updatedSuperHero = superHeroService.update(id, superHero);
        return ResponseEntity.ok().body(updatedSuperHero);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        superHeroService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}
