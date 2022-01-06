package com.karan.rpg.dtos;

import com.karan.rpg.models.Classe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombattantDTO {

    private String nom;
    private Classe classe;
    private int pdv;



}
