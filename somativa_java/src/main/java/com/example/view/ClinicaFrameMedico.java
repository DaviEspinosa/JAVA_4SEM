package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.controller.PacienteController;
import com.example.model.Paciente;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClinicaFrameMedico extends JFrame {
    private PacienteController pacienteController;
    private JTextField buscaNomeField; // Campo para busca
    private JTextField nomeField;
    private JTextField dataConsultaField;
    private JTextField historicoMedicoField;
    private JTable pacientesTable;
    private DefaultTableModel tableModel;

    public ClinicaFrameMedico(PacienteController pacienteController) {
        this.pacienteController = pacienteController;
        setTitle("Buscar Paciente");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para busca
        JPanel buscaPanel = new JPanel();
        buscaPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buscaPanel.setBorder(BorderFactory.createTitledBorder("Nome Paciente"));

        buscaNomeField = new JTextField(20); // Campo para o nome da busca
        buscaNomeField.setFont(new Font("Arial", Font.PLAIN, 14));
        JButton buscarButton = new JButton("Buscar");

        buscarButton.setBackground(Color.decode("#006465")); // Cor do botão
        buscarButton.setForeground(Color.WHITE);
        buscarButton.setFocusPainted(false); // Remove contorno do foco

        buscaPanel.add(buscaNomeField);
        buscaPanel.add(buscarButton);

        // Painel central para exibição dos dados do paciente
        JPanel dadosPanel = new JPanel();
        dadosPanel.setLayout(new GridLayout(2, 4, 10, 10));

        nomeField = new JTextField("");
        dataConsultaField = new JTextField("");
        historicoMedicoField = new JTextField("");

        dadosPanel.add(new JLabel("Nome:"));
        dadosPanel.add(nomeField);
        dadosPanel.add(new JLabel("Data da Consulta:"));
        dadosPanel.add(dataConsultaField);

        JPanel panelNorth = new JPanel();
        panelNorth.setPreferredSize(new Dimension(1000, 88));
        panelNorth.add(buscaPanel);
        panelNorth.add(dadosPanel);
        add(panelNorth, BorderLayout.NORTH);

        // Histórico médico no centro
        JPanel historicoPanel = new JPanel();
        historicoPanel.setLayout(new GridLayout(3, 1, 10, 10));

        historicoPanel.add(new JLabel("Histórico Médico:"));
        historicoPanel.add(historicoMedicoField);

        // Criar um painel separado para o botão salvar
        JPanel salvarPanel = new JPanel(new FlowLayout());
        JButton salvarButton = new JButton("Salvar");
        salvarButton.setPreferredSize(new Dimension(150, 40));
        salvarButton.setBackground(Color.decode("#006465"));
        salvarButton.setForeground(Color.white); // largura de 150 e altura de 40
        salvarPanel.add(salvarButton);

        historicoPanel.add(salvarPanel);
        historicoMedicoField.setPreferredSize(new Dimension(500, 15));

        JPanel panelCenter = new JPanel();
        panelCenter.add(historicoPanel);
        add(panelCenter, BorderLayout.CENTER);

        // Configuração da tabela
        String[] columnNames = { "CPF", "Nome", "Data Consulta", "Telefone", "Endereço" };
        tableModel = new DefaultTableModel(columnNames, 0);
        pacientesTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(pacientesTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.SOUTH); // Coloca a lista de pacientes na parte inferior

        // Ação do botão salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = buscaNomeField.getText(); // Nome do paciente a ser atualizado
                String novoHistoricoMedico = historicoMedicoField.getText();

                // Atualiza o paciente no banco de dados
                pacienteController.editarPaciente(nomePaciente, novoHistoricoMedico);
                // Limpar os campos após salvar
                nomeField.setText("");
                dataConsultaField.setText("");
                historicoMedicoField.setText("");
                atualizarListaPacientes(); // Atualiza a lista na interface
            }
        });

        // Ação do botão buscar
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = buscaNomeField.getText(); // Pega o nome do campo de busca
                Paciente paciente = pacienteController.buscarPacientePorNome(nomePaciente);

                if (paciente != null) {
                    nomeField.setText(paciente.getNome());
                    dataConsultaField.setText(paciente.getDataConsulta());
                    historicoMedicoField.setText(paciente.getHistoricoMedico());
                } else {
                    JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                    nomeField.setText("");
                    dataConsultaField.setText("");
                    historicoMedicoField.setText("");
                }

                atualizarListaPacientes(); // Atualiza a lista após busca
            }
        });

        // Inicializa a lista de pacientes
        atualizarListaPacientes();
    }

    // Método para atualizar a lista de pacientes na tabela
    private void atualizarListaPacientes() {
        tableModel.setRowCount(0); // Limpa os dados atuais da tabela
        List<Paciente> pacientesList = pacienteController.listarPacientes(); // Obtém a lista de pacientes

        for (Paciente paciente : pacientesList) {
            // Adiciona as informações do paciente à tabela
            tableModel.addRow(new Object[] {
                    paciente.getCpf(),
                    paciente.getNome(),
                    paciente.getDataConsulta(),
                    paciente.getTelefone(),
                    paciente.getEndereco()
            });
        }
    }
}
