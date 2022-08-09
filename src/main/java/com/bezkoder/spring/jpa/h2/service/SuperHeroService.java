package com.bezkoder.spring.jpa.h2.service;

import com.bezkoder.spring.jpa.h2.model.SuperHero;

import java.util.List;

public interface SuperHeroService {

    List<?> findAll();

    SuperHero findById(int id);

    SuperHero save(SuperHero superHero);

    SuperHero update(int id, SuperHero superHero);

    void delete(int id);
}
