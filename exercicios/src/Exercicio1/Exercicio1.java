package Exercicio1;
import java.util.Scanner;

public class Exercicio1 {

    public void exercicio1() {

        Scanner sc = new Scanner(System.in);
        double[] notas = new double[4];

        System.out.println("=================================================");
        System.out.println("             Seja Bem vindo ao Sistema           ");
        System.out.println("================================================= \n");
        System.out.println("Digite sua nota em Matemática:\n");
        notas[0] = sc.nextDouble();
        System.out.println("Digite sua nota em Português:\n");
        notas[1] = sc.nextDouble();
        System.out.println("Digite sua nota em Ciências:\n");
        notas[2] = sc.nextDouble();
        System.out.println("Digite sua nota em Geografia:\n");
        notas[3] = sc.nextDouble();
        double mediaAluno = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;

        if (mediaAluno >= 9) {
            double bonus = mediaAluno * 0.10;
            double notaComBonus = bonus + mediaAluno;
            System.out.println("Parabéns você tirou uma nota acima de 9 em todas as matérias, sua nota atual é de:"
                    + notaComBonus);
        } else if (mediaAluno >= 7) {
            System.out.println("Parabéns você está aprovado!!!");
        } else if (mediaAluno > 5 && mediaAluno < 6.9) {
            System.out.println("Você precisa recuperar sua nota!!");
        } else if (mediaAluno < 5) {
            System.out.println("Aluno Reprovado!!!");
        }

    }

}