package com.karan.rpg.repositories;

import com.karan.rpg.models.Personnage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonnageRepository extends MongoRepository<Personnage, String> {
}
