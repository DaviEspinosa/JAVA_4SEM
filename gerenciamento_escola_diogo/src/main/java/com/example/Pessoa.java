package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pessoa {
    private String nome;
    private String cpf;

    public String exibirInfo(){
        return "Nome:"+nome+"CPF:"+cpf;
    }
}
