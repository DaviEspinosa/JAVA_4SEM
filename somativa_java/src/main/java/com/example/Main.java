package com.example;

import java.sql.Connection;
import com.example.connection.ConnectionFactory;
import com.example.controller.FuncionarioController;
import com.example.controller.PacienteController;
import com.example.view.LoginFuncionario;

public class Main {
    public static void main(String[] args) {
        // Criar conexão com o banco de dados
        Connection connection = ConnectionFactory.createConnection();
        
        // Passar a conexão para o PacienteController
        PacienteController controller = new PacienteController(connection);
        FuncionarioController funcionarioController = new FuncionarioController(connection, controller);

        // Criar o frame e torná-lo visível
        LoginFuncionario frame = new LoginFuncionario(funcionarioController);
        frame.setVisible(true);

        // Ao final, fechar a conexão com o banco de dados
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConnectionFactory.closeConnection();
        }));
    }
}
