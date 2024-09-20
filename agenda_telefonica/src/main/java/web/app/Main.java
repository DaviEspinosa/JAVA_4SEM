package web.app;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {

        AgendaTelefonica agenda = new AgendaTelefonica(5);
        int operador = 0;

        do {
            System.out.println("======Agenda Telefônica======");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contato");
            System.out.println("3. Buscar Contato");
            System.out.println("4. Remover Contato");
            System.out.println("5. Sair");

            operador = Integer.parseInt(JOptionPane.showInputDialog("Digite a Operação"));
            switch (operador) {
                case 1:
                    try {
                        String nome = JOptionPane.showInputDialog("Insira o Nome:");
                        String telefone = JOptionPane.showInputDialog("Insira o Telefone:");
                        Contato contato = new Contato(nome, telefone);
                        agenda.addContato(contato);

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    agenda.listarContato();
                    break;
                case 3:
                String buscarNome = JOptionPane.showInputDialog("Buscar pelo Nome");
                    agenda.buscarContato(buscarNome);
                    break;
                case 4:
                String removerNome = JOptionPane.showInputDialog("Buscar pelo Nome");
                    agenda.removerContato(removerNome);
                    break;
                default:
                    break;
            }
        } while (operador != 5);

    }
}