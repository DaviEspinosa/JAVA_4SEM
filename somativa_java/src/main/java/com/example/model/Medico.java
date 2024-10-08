package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Medico {
   
    private int id;
    private String nome;
    private String especialidade;
    private String crm;
    private String senha;
}
// CREATE TABLE medico (
//     id SERIAL PRIMARY KEY,         -- ID do médico, gerado automaticamente
//     nome VARCHAR(100) NOT NULL,    -- Nome do médico
//     especialidade VARCHAR(100),    -- Especialidade do médico
//     crm VARCHAR(20) UNIQUE NOT NULL, -- CRM do médico, deve ser único
//     senha VARCHAR(255) NOT NULL     -- Senha do médico
// );