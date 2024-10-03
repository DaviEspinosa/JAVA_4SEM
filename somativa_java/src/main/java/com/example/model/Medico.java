package com.example.model;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medico {
   
    // atributos
    private ObjectId id;
    private String nome;
    private String especialidade;
    private String crm;

}
