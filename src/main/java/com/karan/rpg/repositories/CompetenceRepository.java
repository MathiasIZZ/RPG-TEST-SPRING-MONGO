package com.karan.rpg.repositories;

import com.karan.rpg.models.Competence;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompetenceRepository extends MongoRepository<Competence, String> {

    Competence findByNom(String nom);

}
