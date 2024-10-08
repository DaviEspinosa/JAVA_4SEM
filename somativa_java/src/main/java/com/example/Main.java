package com.example;

import java.sql.Connection;

import com.example.connection.ConnectionFactory;
import com.example.controller.AdministradorController;
import com.example.controller.FuncionarioController;
import com.example.controller.MedicoController;
import com.example.controller.PacienteController;
import com.example.model.Paciente;

import com.example.view.OptionFrame;

public class Main {
    public static void main(String[] args) {
        // Criar conexão com o banco de dados
        Connection connection = ConnectionFactory.createConnection();
        Paciente paciente = new Paciente();
        // Passar a conexão para o PacienteController
        PacienteController pacienteController = new PacienteController(connection, paciente);
        AdministradorController admController = new AdministradorController(connection);
        FuncionarioController funcionarioController = new FuncionarioController(connection, pacienteController);
        MedicoController medicoController = new MedicoController(connection);
        // Criar o frame e torná-lo visível
        OptionFrame frame = new OptionFrame(admController, funcionarioController, medicoController, pacienteController);
        frame.setVisible(true);
        
        // Ao final, fechar a conexão com o banco de dados
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ConnectionFactory.closeConnection();
        }));
    }
}












// LoginFuncionario frame = new LoginFuncionario(funcionarioController);
// ClinicaFrame frame = new ClinicaFrame(pacientecontroller,admController);
// ClinicaFrameMedico frame = new ClinicaFrameMedico(pacienteController);
// LoginMedico frame = new LoginMedico(medicoController,pacienteController);