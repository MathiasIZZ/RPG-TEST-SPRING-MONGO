package com.karan.rpg.services.competences;

import com.karan.rpg.models.Classe;
import com.karan.rpg.repositories.ClasseRepository;
import com.karan.rpg.services.GenericService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ClasseService implements GenericService<Classe> {

    private ModelMapper mapper;
    private ClasseRepository repository;

    public ClasseService(ModelMapper mapper, ClasseRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }



    @Override
    public List<Classe> findAll() {
        return repository.findAll();
    }

    @Override
    public Classe findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Classe create(Classe entity) {
        return repository.save(entity);
    }

    @Override
    public Classe update(Classe entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {

    }
}
