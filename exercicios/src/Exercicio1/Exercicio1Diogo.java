package Exercicio1;

import java.util.Scanner;

public class Exercicio1Diogo {

    Scanner sc = new Scanner(System.in);
    double[] notas = new double[4];
    double mediaNotas = 0;
    boolean bonus = true;

    public void calcularMediaNotas() {

        // Lê as notas e soma na média
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite sua nota " + (i + 1) + ":");
            notas[i] = sc.nextDouble();
            mediaNotas += notas[i];

            // Se alguma nota for menor que 9, o bônus é removido
            if (notas[i] < 9) {
                bonus = false;
            }
        }

        // Calcula a média
        mediaNotas /= notas.length;

        // Aplica o bônus se todas as notas forem 9 ou mais
        if (bonus) {
            mediaNotas = (mediaNotas * 1.1 > 10) ? 10 : mediaNotas * 1.1;
        }

        // Verifica a condição de aprovação, recuperação ou reprovação
        if (mediaNotas >= 7) {
            System.out.println("Aprovado com média: " + mediaNotas);
        } else if (mediaNotas >= 5) {
            System.out.println("Recuperação com média: " + mediaNotas);
        } else {
            System.out.println("Reprovado com média: " + mediaNotas);
        }
    }
}
