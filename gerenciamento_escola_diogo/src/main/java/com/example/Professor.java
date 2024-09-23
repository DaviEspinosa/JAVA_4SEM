package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Professor extends Pessoa{
    public Professor(String nome, String cpf) {
        super(nome, cpf);
    }

    // atributos 
    private double salario;

    @Override
    public String exibirInfo() {
        super.exibirInfo();
        return "Salário:"+salario;
    }
    
}