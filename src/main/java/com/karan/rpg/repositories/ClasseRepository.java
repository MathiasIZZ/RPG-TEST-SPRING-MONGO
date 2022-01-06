package com.karan.rpg.repositories;

import com.karan.rpg.models.Classe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClasseRepository extends MongoRepository<Classe, String> {
}
