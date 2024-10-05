package com.example.connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.example.model.Paciente;

public class PacienteDAO {
    
    private Connection connection;
    private List<Paciente> listPacientes;

    public PacienteDAO (Connection connection){
        this.connection = ConnectionFactory.createConnection();
    }

    public void addPaciente(Paciente paciente){
        String sql = "INSERT INTO pacientes (cpf, nome, historico_medico, data_nascimento, telefone, endereco) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            if (preparedStatement!=null) {
             
            preparedStatement.setString(1, paciente.getCpf());
            preparedStatement.setString(2, paciente.getNome());
            preparedStatement.setString(3, paciente.getHistoricoMedico());
            preparedStatement.setString(4, paciente.getDataNascimento());
            preparedStatement.setString(5, paciente.getTelefone());
            preparedStatement.setString(6, paciente.getEndereco());

            preparedStatement.executeUpdate();
            System.out.println("Paciente adicionado com sucesso!");   
            }else{
                System.out.println("Erro ao adicionar paciente!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
