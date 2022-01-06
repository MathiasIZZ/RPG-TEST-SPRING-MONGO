package com.karan.rpg.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competence implements com.karan.rpg.models.interfaces.Competence {

    private String id;
    private String nom;
    private int degats;


    @Override
    public void infligerDegats(Combattant adversaire) {}
}
