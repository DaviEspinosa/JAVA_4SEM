package com.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/clinica_saude";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres"; 
    private static Connection connection = null;

    // cria conexão com o banco
    public static Connection createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (Exception e) {
            throw new Error("Falha ao conectar no banco de dados:" + e.getMessage());
        }
    }

    // Fechar conexão com o banco
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
