package com.bezkoder.spring.jpa.h2.repository;


import com.bezkoder.spring.jpa.h2.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {

}
