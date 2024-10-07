package com.example.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Administrador;

public class AdministradorDAO {

    public Connection connection;

    public AdministradorDAO(Connection connection) {
        this.connection = ConnectionFactory.createConnection();
    }

    public boolean validarAdm(Administrador administrador) {
        String sql = "SELECT * FROM administrador WHERE nome = ? AND senha = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Definir os parâmetros da consulta
            preparedStatement.setString(1, administrador.getNome());
            preparedStatement.setString(2, administrador.getSenha());

            // Executar a consulta e obter os resultados
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verificar se há algum registro que corresponde ao nome e senha
            if (resultSet.next()) {
                return true; // Funcionário encontrado, credenciais válidas
            } else {
                return false; // Nenhum registro encontrado, credenciais inválidas
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Se houver algum erro na consulta
        }
    }
}
