package com.example.controller;

import java.sql.Connection;

import com.example.connection.FuncionarioDAO;
import com.example.model.Funcionario;

public class FuncionarioController {
    private FuncionarioDAO funcionarioDAO;
    private PacienteController pacienteController;
    public FuncionarioController(Connection connection, PacienteController pacienteController){
        this.funcionarioDAO = new FuncionarioDAO(connection);
        this.pacienteController = pacienteController;
    }
     
    public PacienteController getpPacienteController(){
        return pacienteController;
    }

    public void cadastrar(Funcionario funcionario){
        funcionarioDAO.cadastrarFuncionario(funcionario);
    }

    public boolean validacao(String nome, String senha) {
        // Cria um objeto Funcionario com os parâmetros recebidos
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setSenha(senha);
        
        // Chama o método de validação no DAO e retorna o resultado
        return funcionarioDAO.validacao(funcionario);
    }

}
