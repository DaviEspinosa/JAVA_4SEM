package br.com.davi;

public class Retomando {
    
    public void operacoes(){
        int a = 20, b = 5;
        double c = 7.8;
        char letra = 'D';
        boolean teste = false;

        // utilizando operador relacional e lógico
        teste = (a>b) && (c<9);

        System.out.println("Resultado de a + b: " + (a+b));
        System.out.println("Resultado para teste: "+ teste);
    }
}