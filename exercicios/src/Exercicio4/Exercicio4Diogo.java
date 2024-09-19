package Exercicio4;

import java.util.Scanner;

// RECURSIVIDADE - chamando um método dentro dele mesmo
public class Exercicio4Diogo {

    int numero =- 1;

    Scanner sc = new Scanner(System.in);

    public long calculoFatorial(int n){
        if (n==0 || n==1) {
            return 1;
        }
        else{
            return n*calculoFatorial(n-1);
        }
    }

    public void calculadora() throws Exception{
        System.out.println("Digite um n° para calcular o fatorial");
        numero = sc.nextInt();

        if (numero<0) {
            throw new Exception("O número deve ser positivo");
        }
        try {
            System.out.println(calculoFatorial(numero));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
