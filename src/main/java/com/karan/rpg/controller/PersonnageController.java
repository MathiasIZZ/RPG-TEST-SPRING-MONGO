package com.karan.rpg.controller;

import com.karan.rpg.models.Personnage;
import com.karan.rpg.services.personnage.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("personnages")
public class PersonnageController {

    @Autowired
    private PersonnageService service;

    @GetMapping()
    public List<Personnage> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Personnage findById(@PathVariable String id) {
        return this.service.findById(id);
    }

    @PostMapping()
    public Personnage create(@RequestBody Personnage personnage) {

        return this.service.create(personnage);
    }
}
