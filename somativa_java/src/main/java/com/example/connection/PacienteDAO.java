package com.example.connection;

// import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Paciente;

public class PacienteDAO {

    private Connection connection;
    // private List<Paciente> listPacientes;

    public PacienteDAO(Connection connection) {
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

    public List<Paciente> listasPacientes(){
        List<Paciente> pacientesLista = new ArrayList<>();

        String sql = "SELECT * FROM pacientes";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            if (preparedStatement!=null) {
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setId(rs.getInt("id"));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setHistoricoMedico(rs.getString("historico_medico"));
                    paciente.setDataNascimento(rs.getString("data_nascimento"));
                    paciente.setTelefone(rs.getString("telefone"));
                    paciente.setEndereco(rs.getString("endereco"));

                    pacientesLista.add(paciente);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientesLista;
    }
    
    public void deletarPaciente(Paciente paciente) {
        String sql = "DELETE FROM pacientes WHERE nome = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Define o nome do paciente a ser deletado
            preparedStatement.setString(1, paciente.getNome());
    
            // Executa a atualização no banco de dados
            int rowsAffected = preparedStatement.executeUpdate();
    
            // Verifica se o paciente foi deletado com sucesso
            if (rowsAffected > 0) {
                // Se o paciente foi removido do banco de dados, remova-o da lista local
                listasPacientes().remove(paciente);
                System.out.println("Paciente deletado com sucesso.");
            } else {
                System.out.println("Paciente não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
