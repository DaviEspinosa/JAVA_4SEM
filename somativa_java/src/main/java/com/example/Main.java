package com.example;

import java.sql.Connection;

import com.example.connection.ConnectionFactory;
import com.example.controller.AdministradorController;
import com.example.controller.FuncionarioController;
import com.example.controller.PacienteController;
import com.example.view.ClinicaFrame;
import com.example.view.LoginFuncionario;

public class Main {
    public static void main(String[] args) {
        // Criar conexão com o banco de dados
        Connection connection = ConnectionFactory.createConnection();
        
        // Passar a conexão para o PacienteController
        PacienteController controller = new PacienteController(connection);
        AdministradorController admController = new AdministradorController(connection);
        FuncionarioController funcionarioController = new FuncionarioController(connection, controller);

        // Criar o frame e torná-lo visível
        // LoginFuncionario frame = new LoginFuncionario(funcionarioController);
        ClinicaFrame frame = new ClinicaFrame(controller,admController);

        // Mostrar a tela do frame
        // frame.pack(); // Ajusta o frame para ocupar toda a tela
        // frame.setSize(800, 600); // Define o tamanho do frame
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a ação ao fechar o frame
        // frame.setLayout(new BorderLayout()); // Define o layout do frame
        // frame.setVisible(true); // Mostra o frame no monitor
        frame.setVisible(true);

        // Ao final, fechar a conexão com o banco de dados
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConnectionFactory.closeConnection();
        }));
    }
}
