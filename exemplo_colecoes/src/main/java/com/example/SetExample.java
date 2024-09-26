package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    private Set<String> nomeSet;

    public SetExample(){
        nomeSet = new HashSet<>();
    }

    public void addNome(String nome){
        nomeSet.add(nome);
        System.out.println(nomeSet.hashCode());
    }

    public void listarNome(){
        System.out.println(nomeSet);
    }

    public void removerNomes(String nomes){
        try {
            nomeSet.remove(nomes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
