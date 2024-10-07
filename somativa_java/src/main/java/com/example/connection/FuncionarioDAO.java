package com.example.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.Funcionario;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO(Connection connection){
        this.connection = ConnectionFactory.createConnection();
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        String sql = "INSERT INTO funcionarios (nome, senha) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            if (preparedStatement!=null){ 
                preparedStatement.setString(1, funcionario.getNome());
                preparedStatement.setString(2, funcionario.getSenha());

                preparedStatement.executeUpdate();
                System.out.println("Funcionário cadastrado no Banco com sucesso!");
            }else{
                System.out.println("Erro ao cadastrar Funcionário no Banco!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para validar o login do funcionário
    public boolean validacao(Funcionario funcionario){
        String sql = "SELECT * FROM funcionarios WHERE nome = ? AND senha = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Definir os parâmetros da consulta
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getSenha());

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

    public Funcionario buscarPorNome(String nome, String senha) {
        // Lógica para buscar o funcionário no banco de dados pelo nome
        // Certifique-se de que a senha armazenada no banco é recuperada corretamente
        String sql = "SELECT nome, senha FROM funcionarios WHERE nome = ?";
        // Execute a query e retorne um objeto Funcionario
        // Exemplo:
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setSenha(senha);  // Exemplo de senha hasheada vinda do banco
        return funcionario;
    }
}
