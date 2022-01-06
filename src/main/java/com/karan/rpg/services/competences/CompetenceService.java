package com.karan.rpg.services.competences;

import com.karan.rpg.models.Competence;
import com.karan.rpg.repositories.CompetenceRepository;
import com.karan.rpg.services.GenericService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class CompetenceService implements GenericService<Competence> {

    private CompetenceRepository repository;
    private ModelMapper mapper;

    public CompetenceService(CompetenceRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Competence findByNom(String nom) {

        if (nom == null || nom == "") {
            throw new IllegalArgumentException("La valeur rentrée est nulle");
        }
            Competence comp1 = null;

        return repository.findByNom(nom);
    }

    @Override
    public List<Competence> findAll() {
        return repository.findAll();
    }

    @Override
    public Competence findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Competence create(Competence entity) {
        return repository.save(entity);
    }

    @Override
    public Competence update(Competence entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {

    }
}
