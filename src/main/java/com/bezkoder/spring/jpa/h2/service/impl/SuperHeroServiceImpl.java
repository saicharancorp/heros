package com.bezkoder.spring.jpa.h2.service.impl;

import com.bezkoder.spring.jpa.h2.model.SuperHero;
import com.bezkoder.spring.jpa.h2.repository.SuperHeroRepository;
import com.bezkoder.spring.jpa.h2.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

    @Override
    public SuperHero findById(int id) {
        try {
            return repository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public SuperHero update(int id, SuperHero superHero) {
        try {
            repository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        superHero.setId(id);
        return repository.save(superHero);
    }

    @Override
    public void delete(int id) {
       repository.findById(id).ifPresent(superHero -> repository.delete(superHero));
    }
}
