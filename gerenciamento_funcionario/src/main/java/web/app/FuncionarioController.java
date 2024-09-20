package web.app;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FuncionarioController {
    
    private ArrayList<Funcionario> listFuncionarios;
    private int contador;

    public FuncionarioController() {
        listFuncionarios = new ArrayList<>();
    }

    public void addFuncionario(Funcionario funcionario){
        listFuncionarios.add(funcionario);
        JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso...");
    }

    public void listarFuncionario(){
        if (listFuncionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado!");
        }
    }
}
