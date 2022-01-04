package com.karan.rpg.services.personnage;

import com.karan.rpg.models.Personnage;
import com.karan.rpg.repositories.PersonnageRepository;
import com.karan.rpg.services.GenericService;

import java.util.List;

public class PersonnageService implements GenericService<Personnage> {

    private PersonnageRepository repository;

    public PersonnageService(PersonnageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Personnage> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Personnage findById(String id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Personnage create(Personnage entity) {

        if (entity.getNom() == null || entity.getNom().length() == 0) {
            throw new IllegalArgumentException("Le personnage créé n'a pas de nom");
        }

        return this.repository.save(entity);
    }

    @Override
    public Personnage update(Personnage entity) {
        return this.repository.save(entity);
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }
}
