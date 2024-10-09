package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Administrador {
    // atributos
    private int id;
    private String nome;
    private String senha;
}

// CREATE table ADMINISTRADOR (
//     ID SERIAL PRIMARY KEY,
//     NOME VARCHAR(255) NOT NULL,
//     SENHA VARCHAR(255) NOT NULL
// )

// INSERT INTO ADMINISTRADOR (NOME, SENHA) VALUES ('Davi Pedrosa', 'senha123')