package web.app;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws Exception {
        FuncionarioController funcionarioController = new FuncionarioController();

        int operacao = 0;

        do {
            try {
                operacao = Integer.parseInt(JOptionPane.showInputDialog("\n"+
                "============Gerenciamento de Funcionario===========\n"+
                "1 - Cadastrar Funcionário\n"+
                "2 - Listar Funcionários\n"+
                "3 - Remover Funcionários\n"+
                "4 - Média Salário \n"+
                "5 - Sair"));
            } catch (Exception e) {
                System.out.println(e);
                operacao = 0;
            }

            switch (operacao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o Nome:");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade:"));
                    double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o Salário:"));
                    funcionarioController.addFuncionario(new Funcionario(nome, idade, salario));
                    break;
                case 2:
                    funcionarioController.listarFuncionario();
                break;
                case 3:
                    String nomeF = JOptionPane.showInputDialog("Digite o Nome do Funcionário a ser removido");
                    funcionarioController.removeFuncionario(nomeF);
                break;
                case 4:
                     funcionarioController.mediaSalario();           
                break;
                case 5:
                System.out.println("Saindo do Sistema");
                break;
                default:
                    break;
            }
        } while (operacao!=5);
    }
}