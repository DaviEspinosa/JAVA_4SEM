package web.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    
// se usar apenas array a lista não será dinamica e epreciso definir um tamanho para minha lista
// já usando arrayList se torna algo dinamico

    private List<Funcionario> listFuncionarios;//list é uma interface
    // private int contador;

    public FuncionarioController() {
        listFuncionarios = new ArrayList<>();//arrayList instancia a list
    }

    public void addFuncionario(Funcionario funcionario){
        listFuncionarios.add(funcionario);
        JOptionPane.showMessageDialog(null, "Funcionário adicionado com sucesso...");
    }

    public void listarFuncionario(){
        //criando um objeto funcionario para cada linha do meu listFuncionarios
        if (listFuncionarios.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!!!");
            // System.out.println("Lista Vazia!!");
        }else{
            for (Funcionario funcionario : listFuncionarios) {
                JOptionPane.showMessageDialog(null, funcionario.toString());
                //System.out.println( funcionario.toString());
            }   
        }
    }

    public void removeFuncionario(String nome) throws Exception{

        try {
            boolean encontrado = false;

            for (Funcionario funcionario : listFuncionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    listFuncionarios.remove(funcionario);
                    encontrado = true;      
                }
            }
            if (!encontrado) {
                throw new Exception("Usuario não Encontrado...");
            }            
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public double mediaSalario(){

        double mediaSalario = 0;
        if (listFuncionarios.size() == 0) {
            return mediaSalario();
        }else{
            for (Funcionario funcionario : listFuncionarios) {
                mediaSalario += funcionario.getSalario();
            }
            return mediaSalario/listFuncionarios.size();
        }

    }
}
