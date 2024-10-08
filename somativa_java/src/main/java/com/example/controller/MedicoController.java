package com.example.controller;

import java.sql.Connection;


import com.example.connection.MedicoDAO;

import com.example.model.Medico;

public class MedicoController extends UsuarioController {
        private MedicoDAO medicoDAO;

    public MedicoController(Connection connection) {
        this.medicoDAO = new MedicoDAO(connection);
    }

    @Override
    public boolean validacao(String nome, String senha) {
        // Cria um objeto Funcionario com os parâmetros recebidos
        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setSenha(senha);

        // Chama o método de validação no DAO e retorna o resultado
        return medicoDAO.validarMedico(medico);
    }
}
