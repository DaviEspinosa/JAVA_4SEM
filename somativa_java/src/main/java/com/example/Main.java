package com.example;

import java.sql.Connection;
import com.example.connection.ConnectionFactory;
import com.example.controller.PacienteController;
import com.example.view.ClinicaFrame;

public class Main {
    public static void main(String[] args) {
        // Criar conexão com o banco de dados
        Connection connection = ConnectionFactory.createConnection();
        
        // Passar a conexão para o PacienteController
        PacienteController controller = new PacienteController(connection);

        // Criar o frame e torná-lo visível
        ClinicaFrame frame = new ClinicaFrame(controller);
        frame.setVisible(true);

        // Ao final, fechar a conexão com o banco de dados
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConnectionFactory.closeConnection();
        }));
    }
}
