package com.karan.rpg;

import com.karan.rpg.models.Classe;
import com.karan.rpg.repositories.ClasseRepository;
import com.karan.rpg.services.competences.ClasseService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ClasseTest {

    AutoCloseable closeable;

    List<Classe> classeList = new ArrayList<>();

    @Mock
    private ClasseRepository repository;

    @InjectMocks
    private ClasseService service;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);

        classeList.add(new Classe());
        classeList.add(new Classe());

    }

    @AfterEach
    public void closableMocks() throws Exception {
        closeable.close();
    }


    @Test
    @DisplayName("devrait récupérer toutes les classes")
    public void recupAllClasse() {
        Mockito.when(repository.findAll()).thenReturn(this.classeList);
        Assertions.assertTrue(service.findAll().size() == 2);
    }


}
