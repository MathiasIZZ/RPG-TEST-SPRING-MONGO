package com.karan.rpg.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Personnage {
    @Id
    private String id;
    private String nom;
    private int pdv;
}
