package Exercicio3;

import java.util.Scanner;

public class Exercicio3 {

    Scanner sc = new Scanner(System.in);
    double numero1, numero2, soma, multiplicacao, subtracao, divisao, raizQuadrada;
    char operacao;

    public void Sistema() {
        System.out.println("=================================================");
        System.out.println("             Seja Bem vindo ao Sistema           ");
        System.out.println("================================================= \n");
        System.out.println("Digite um número: ");
        numero1 = sc.nextDouble();
        System.out.println("Digite outro número: ");
        numero2 = sc.nextDouble();

        System.out.println("Escolha uma operação:\n 1 - Soma \n 2 - Subtração \n 3 - Multiplicação \n 4 - Divisão");
        operacao = sc.next().charAt(0);
        switch (operacao) {
            case '1':
                soma = numero1 + numero2;
                System.out.println("O resultado da soma é: " + soma);
                break;
            case '2':
                subtracao = numero1 - numero2;
                System.out.println("O resultado da subtração é: " + subtracao);
                break;
            case '3':
                multiplicacao = numero1 * numero2;
                System.out.println("O resultado da multiplicação é: " + multiplicacao);
                break;
            case '4':
                divisao = numero1 / numero2;
                if (numero1 == 0 || numero2 == 0) {
                    System.out.println("O número não pode ser dividido por 0");
                    break;
                }
                System.out.println("O resultado da divisão é: " + divisao);
                break;
            
            case '5':
                // raizQuadrada
                break;
            default:
                System.out.println("erroooooo!");
                break;
        }
    }
}
