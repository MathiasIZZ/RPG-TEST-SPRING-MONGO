package com.karan.rpg;

import com.karan.rpg.models.Competence;
import com.karan.rpg.repositories.CompetenceRepository;
import com.karan.rpg.services.competences.CompetenceService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

public class CompetencesTest {

    AutoCloseable closeable;

    @Mock
    private CompetenceRepository repository;

    @InjectMocks
    private CompetenceService service;

    List<Competence> competenceList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        Competence comp1 = new Competence("1", "Jet de feu", 50);
        Competence comp2 = new Competence("2", "Jet d'eau", 35);
        competenceList.add(comp1);
        competenceList.add(comp2);
    }

    @AfterEach
    public void closeMocks() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("Devrait me retourner une liste de competences de taille 2")
    public void retourneCompetenceLength2() {
        when(repository.findAll()).thenReturn(this.competenceList);

        Assertions.assertTrue(service.findAll().size() == 2);
    }

    @Test
    @DisplayName("devrait récupérer une compétence")
    public void recupereCompetence() {
        /*
        GIVEN : Liste de compétences, String nom
        WHEN : appelle de la méthode findByNom du serviceCompetence
        THEN : récupère une compétence
         */
        String nom = "Extra";
        when(repository.findByNom(any(String.class))).thenAnswer( i -> {
            Competence competence = i.getArgument(0);

            return competence;
        });
        Competence competence = service.findByNom(nom);

        Assertions.assertInstanceOf(Competence.class, competence);
    }

    @Test
    @DisplayName("Devrait lever une exception lors d'une recherche d'une competence sans nom")
    public void recupererCompetenceSansNom() {

        Competence competence = new Competence("3", "", 45);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.service.create(competence);
        });

    }







}
