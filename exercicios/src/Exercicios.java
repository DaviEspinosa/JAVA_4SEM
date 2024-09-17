import java.util.Scanner;

public class Exercicios {

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

    public void exercicio2() {

    }

    public void exercicio3() {

        Scanner sc = new Scanner(System.in);
        double numero1, numero2, soma, multiplicacao, subtracao, divisao;
        char operacao;

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
                if (divisao % 2 == 0) {
                    System.out.println("Deu errado!!");
                } else if (numero1 == 0 || numero2 == 0) {
                    System.out.println("O número não pode ser dividido por 0");
                    break;
                }
                System.out.println("O resultado da divisão é: " + divisao);
                break;
            default:
                System.out.println("erroooooo!");
                break;
        }

    }
}