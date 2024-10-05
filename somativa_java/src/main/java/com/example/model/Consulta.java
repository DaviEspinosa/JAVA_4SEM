package com.example.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consulta {

    private int id;
    private LocalDate date;
    Paciente paciente;
    Medico medico;
    private String obsercacoes;
}
