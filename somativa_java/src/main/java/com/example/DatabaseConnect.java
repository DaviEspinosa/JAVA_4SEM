package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private static final String URL = "jdbc:postgresql://localhost:5432/clinica_saude";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres"; 
    private static Connection connection = null;

    // Criar conexão com o banco de dados
    public static Connection createConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conectado ao PostgreSQL com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados PostgreSQL");
            e.printStackTrace();
        }
        return connection;
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
