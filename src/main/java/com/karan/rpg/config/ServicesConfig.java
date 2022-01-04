package com.karan.rpg.config;

import com.karan.rpg.repositories.PersonnageRepository;
import com.karan.rpg.services.personnage.PersonnageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public PersonnageService personnageServiceFactory(PersonnageRepository repository) {
        return new PersonnageService(repository);
    }
}
