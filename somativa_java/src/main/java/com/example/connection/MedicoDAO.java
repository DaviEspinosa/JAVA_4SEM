package com.example.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Administrador;
import com.example.model.Funcionario;
import com.example.model.Medico;

public class MedicoDAO {
    private Connection connection;

    public MedicoDAO(Connection connection) {
        this.connection = ConnectionFactory.createConnection();
    }

     public void cadastrarMedico(Medico medico){
        String sql = "INSERT INTO medico (nome, senha) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            if (preparedStatement!=null){ 
                preparedStatement.setString(1, medico.getNome());
                preparedStatement.setString(2, medico.getSenha());

                preparedStatement.executeUpdate();
                System.out.println("Médico cadastrado no Banco com sucesso!");
            }else{
                System.out.println("Erro ao cadastrar Médico no Banco!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validarMedico(Medico medico) {
        String sql = "SELECT * FROM medico WHERE nome = ? AND senha = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Definir os parâmetros da consulta
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getSenha());

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
