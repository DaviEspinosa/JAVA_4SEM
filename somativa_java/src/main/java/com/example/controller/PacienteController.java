package com.example.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;

import com.example.connection.PacienteDAO;
import com.example.model.Paciente;

public class PacienteController {

    private List<Paciente> listaPaciente;
    private PacienteDAO pacienteDAO;

    

    public PacienteController(Connection connection) {
        listaPaciente = new ArrayList<Paciente>();
        this.pacienteDAO = new PacienteDAO(connection);
    }
    // metodos

    // adicionar
    public void addPaciente(Paciente paciente) {
        pacienteDAO.addPaciente(paciente);
    }

    // listar
    public List<Paciente> listarPacientes() {
        return pacienteDAO.listasPacientes(); // Método que retorna a lista de pacientes do banco
    }

    // excluir paciente
    public void deletarPaciente(Paciente paciente) {
        // Verifica se o paciente é null
        pacienteDAO.deletarPaciente(paciente);
    }
}
    // public void listarPaciente(JPanel panelList) {

    //     // Definindo os nomes das colunas
    //     String[] colunas = { "ID", "Nome", "CPF", "Data de Nascimento", "Telefone", "Endereço" };

    //     // Criando Matriz para os dados
    //     // Object[][] dados = new Object[listaPaciente.size()][colunas.length];

    //     // // Preencher a Tabela com os dados dos pacientes
    //     // for (int i = 0; i < listaPaciente.size(); i++) {
    //     //     Paciente paciente = listaPaciente.get(i);
    //     //     dados[i][0] = paciente.getId();
    //     //     dados[i][1] = paciente.getNome();
    //     //     dados[i][2] = paciente.getCpf();
    //     //     // dados[i][3] = paciente.getEmail();
    //     //     dados[i][3] = paciente.getDataNascimento();
    //     //     dados[i][4] = paciente.getTelefone();
    //     //     dados[i][5  ] = paciente.getEndereco();
    //     // }

    //     // Criar o JTable com os dados e as colunas
    //     JTable table = new JTable(colunas);

    //     // Adicionar o JTable a um JScrollPane
    //     JScrollPane scrollPane = new JScrollPane(table);
    //     panelList.add(scrollPane); // Adiciona o JScrollPane ao painel principal

    //     // Atualiza o painel para mostrar as mudanças
    //     panelList.revalidate();
    //     panelList.repaint();
    // }
