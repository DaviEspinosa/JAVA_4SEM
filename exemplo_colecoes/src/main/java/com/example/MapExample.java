package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    private Map<String, Integer> nomesIdades;

    public MapExample(){
        nomesIdades = new HashMap<>();
    }

    public void addNome(String nome, int idade){
        nomesIdades.put(nome, idade);
        // System.out.println(nomesIdades.hashCode();
    }
}
