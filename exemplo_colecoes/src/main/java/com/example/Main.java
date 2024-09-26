package com.example;

public class Main {
    public static void main(String[] args) {
       ListExample set = new ListExample();

       set.addNome("Davi");
       set.addNome("Adriana");
       set.addNome("Jaime");
       set.addNome("Benjamin");
       set.listarNome();
    //    set.editarNomes("Adriana", "Mãe");
    //    set.listarNome();
       set.removerNomes(null);
    }
}