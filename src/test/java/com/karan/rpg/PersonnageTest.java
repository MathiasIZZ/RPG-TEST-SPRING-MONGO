package com.karan.rpg;

import com.karan.rpg.models.Personnage;
import com.karan.rpg.repositories.PersonnageRepository;
import com.karan.rpg.services.personnage.PersonnageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PersonnageTest {

    AutoCloseable closeable;

    @Mock
    private PersonnageRepository repository;

    @InjectMocks
    private PersonnageService service;

    List<Personnage> personnages = new ArrayList<Personnage>();

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        personnages.add(new Personnage("id1", "toto", 100));
        personnages.add(new Personnage("id2", "toto", 100));
        personnages.add(new Personnage("id3", "toto", 100));
    }

    @AfterEach
    public void closeMocks() throws Exception {
        closeable.close();
    }




    @Test
    @DisplayName("Devrait creer une instance de personnage")
    public void createNewPerso(){
        Personnage p = new Personnage("1","toto",100);
        assertInstanceOf(Personnage.class, p);
    }

    @Test
    @DisplayName("Devrait créer un personnage")
    public void insert(){
        Personnage personnage = new Personnage("2","Mathias",100);

        //Mockito.when(repository.save(Mockito.any(Personnage.class))).thenReturn(new Personnage("2","Mathias",100));

        when(repository.save(Mockito.any(Personnage.class))).thenAnswer(i -> {
            Personnage p = i.getArgument(0);
            p.setId("3");

            return p;
        });

        Personnage personnage2 = service.create(personnage);

        assertNotNull(personnage2);
    }

    @Test
    @DisplayName("Devrait lever une exception lors de la création d'un personnage sans nom")
    public void insertSansNom() {
        Personnage personnage = new Personnage(null, null, 100);

        assertThrows(IllegalArgumentException.class, () -> {
            this.service.create(personnage);
        });
    }

    @Test
    @DisplayName("Devrait retourner un personnage avec l'id")
    public void findById() {
        String id = "id1";
        when(repository.findById(any(String.class)))
                .thenReturn(Optional.of(new Personnage(id, "toto", 100)));
        assertNotNull(service.findById(id));
    }

    @Test
    @DisplayName("Devrait lever uner exception car le personnage avec l'id n'existe pas")
    public void findByIdNotFound() {
    /*
    GIVEN service, repo, id
    WHEN appelle de la méthode service.findById(id)
    THEN je récupère une NullPointerException car le personnage n'a pas été trouvé
     */
        String id = "id12";
        when(repository.findById(any(String.class)))
                .thenReturn(Optional.empty());
        assertThrows(NullPointerException.class, () -> {
            service.findById(id);
        });
    }

    @Test
    @DisplayName("Devrait récupérer une liste de personnage de taille 3")
    public void findByAll() {

        when(repository.findAll()).thenReturn(this.personnages);
        assertTrue(service.findAll().size() == 3);
    }







}
