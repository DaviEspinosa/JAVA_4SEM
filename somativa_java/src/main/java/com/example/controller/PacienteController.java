package com.example.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.example.connection.PacienteDAO;
import com.example.model.Paciente;

public class PacienteController {

    private List<Paciente> listaPaciente;
    private PacienteDAO pacienteDAO;

    public PacienteController(Connection connection, Paciente paciente) {
        listaPaciente = new ArrayList<Paciente>();
        this.pacienteDAO = new PacienteDAO(connection);
    }

    // Adicionar
    public void addPaciente(Paciente paciente) {
        pacienteDAO.addPaciente(paciente);
    }

    // Listar
    public List<Paciente> listarPacientes() {
        return pacienteDAO.listasPacientes(); 
    }

    // Excluir paciente
    public void deletarPaciente(Paciente paciente) {
        pacienteDAO.deletarPaciente(paciente);
    }

    // Buscar por nome
    public Paciente buscarPacientePorNome(String nome) {
        return pacienteDAO.buscarPacientePorNome(nome);
    }

    public void editarPaciente(String nome, String novoHistoricoMedico) {
        pacienteDAO.editarPaciente(nome, novoHistoricoMedico);
    }
}
