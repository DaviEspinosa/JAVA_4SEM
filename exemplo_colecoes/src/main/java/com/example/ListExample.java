package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    // atributos
    private List<String> nomesList;

    public ListExample(){
        nomesList = new ArrayList<>();
    }

    public void addNome(String nome){
        nomesList.add(nome);
        System.out.println(nomesList.lastIndexOf(nome));
    }

    public void listarNome(){
        System.out.println(nomesList);
    }

    public void removerNomes(String nomes){
        try {
            nomesList.remove(nomes);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void editarNomes(String nomeAntigo, String nomeNovo){
        try {
            int index = nomesList.indexOf(nomeAntigo);
            nomesList.set(index, nomeNovo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
