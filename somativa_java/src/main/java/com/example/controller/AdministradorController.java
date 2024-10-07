package com.example.controller;

import java.sql.Connection;

import com.example.connection.AdministradorDAO;
import com.example.connection.FuncionarioDAO;
import com.example.model.Administrador;
import com.example.model.Funcionario;

public class AdministradorController extends UsuarioController {

    private AdministradorDAO admDAO;

    public AdministradorController(Connection connection) {
        this.admDAO = new AdministradorDAO(connection);
    }

    @Override
    public boolean validacao(String nome, String senha) {
        // Cria um objeto Funcionario com os parâmetros recebidos
        Administrador adm = new Administrador();
        adm.setNome(nome);
        adm.setSenha(senha);

        // Chama o método de validação no DAO e retorna o resultado
        return admDAO.validarAdm(adm);
    }
}
