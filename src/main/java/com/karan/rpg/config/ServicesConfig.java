package com.karan.rpg.config;

import com.karan.rpg.repositories.PersonnageRepository;
import com.karan.rpg.services.personnage.PersonnageService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;

@Configuration
public class ServicesConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PersonnageService personnageServiceFactory(PersonnageRepository repository, ModelMapper mapper) {
        return new PersonnageService(repository, mapper);
    }
}
