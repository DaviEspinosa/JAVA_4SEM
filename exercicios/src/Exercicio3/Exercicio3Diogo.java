package Exercicio3;

import java.util.Scanner;

public class Exercicio3Diogo {

    double a, b, resultado;
    int escolha;

    Scanner sc = new Scanner(System.in);

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtracao(double a, double b) {
        return a - b;
    }

    public double multiplicacao(double a, double b) {
        return a * b;
    }

    public double divisao(double a, double b) {
        try {
            double resultado = a / b;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        return resultado;
    }

    public double raizQuadrada(double a) throws Exception {
        if (a < 0) {
            throw new Exception("Não existe raiz de número negativo");
        }
        try {
            resultado = Math.sqrt(a);
        } catch (Exception e) {
            System.out.println(e);
        }
        return Math.sqrt(a);
    }

    public void entradaDados(){
        if (escolha >=1 && escolha<5) {
            System.out.println("Digite o valor A: ");
            a = sc.nextDouble();
            System.out.println("Digite o valor B: ");
            b = sc.nextDouble();
        }
        else if (escolha==5) {
            System.out.println("Digite o valor A: ");
            a = sc.nextDouble();
        }
        else if (escolha == 6) {
            System.out.println("Saindo...");
        }
        else{
            System.out.println("Digite um número válido!!!");
        }
    }

    public void menu(){
        System.out.println("=====================");
        System.out.println("=====Calculadora=====");
        System.out.println("=====================");
        System.out.println("1. Soma");
        System.out.println("2. Subtracao");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Sair");
    
        
    }

    public void calcular(){
        do {
            menu();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        entradaDados();
                        somar(a, b);
                        break;
                    case 2:
                        entradaDados();
                        subtracao(a, b);
                        break;
                    case 3:
                        entradaDados();
                        multiplicacao(a, b);
                        break;
                    case 4:
                        entradaDados();
                        divisao(a, b);
                        break;
                    case 5:
                        entradaDados();
                        raizQuadrada(a);
                        break;
                    case 6:
                        break;
                
                    default:
                        break;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (escolha  !=6);
    }
}
