package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {

    private int id;
    // atributos
    private String cpf;
    private String nome;
    private String historicoMedico;
    private String dataConsulta;
    private String telefone;
    private String endereco;
    
}
