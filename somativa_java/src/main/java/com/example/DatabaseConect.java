package com.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConect {
    private static MongoClient mongoClient = null;
    

    private static final Dotenv env = Dotenv.load();
    private static String databaseURL = env.get("DATABASE_URL");

    public static MongoClient createConnect() {
        // se já existir conexão retornar conexão
        if (mongoClient != null) {
            return mongoClient;
        } else {
            mongoClient = (MongoClient) MongoClients.create(databaseURL);
            System.out.println("Conectado com sucesso!!!");
            return mongoClient;
        }
    }

    public void closeConnection(){
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Banco desconectado");
            mongoClient = null;
        }
    }
}
