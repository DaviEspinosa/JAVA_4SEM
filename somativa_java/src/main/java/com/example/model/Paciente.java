package com.example.model;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Paciente {
    // id
    private ObjectId id;
    // atributos
    private String cpf;
    private String nome;
    private String email;
    private String historicoMedico;
    private LocalDate dataNascimento;
    private String telefone;
    private String endereco;
    
}
