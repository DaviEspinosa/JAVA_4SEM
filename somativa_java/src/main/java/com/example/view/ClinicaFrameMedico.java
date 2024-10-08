package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.controller.PacienteController;
import com.example.model.Paciente;

public class ClinicaFrameMedico extends JFrame {
    private PacienteController pacienteController;
    private JTextField buscaNomeField;  // Campo para busca
    private JTextField nomeField;
    private JTextField dataNascimentoField;
    private JTextField historicoMedicoField;

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

        buscaNomeField = new JTextField(20);  // Campo para o nome da busca
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
        dataNascimentoField = new JTextField("");
        historicoMedicoField = new JTextField("");

        dadosPanel.add(new JLabel("Nome:"));
        dadosPanel.add(nomeField);
        dadosPanel.add(new JLabel("Data de Nascimento:"));
        dadosPanel.add(dataNascimentoField);

        JPanel panelNorth = new JPanel();
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
        historicoMedicoField.setPreferredSize(new Dimension(500, 100));

        JPanel panelCenter = new JPanel();
        panelCenter.add(historicoPanel);
        add(panelCenter, BorderLayout.CENTER);

        // Ação do botão salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = buscaNomeField.getText();  // Nome do paciente a ser atualizado
                String novaDataNascimento = dataNascimentoField.getText();
                String novoHistoricoMedico = historicoMedicoField.getText();
        
                // Atualiza o paciente no banco de dados
                pacienteController.editarPaciente(nomePaciente, novoHistoricoMedico);
                // Limpar os campos após salvar
                nomeField.setText("");
                dataNascimentoField.setText("");
                historicoMedicoField.setText("");

                JOptionPane.showMessageDialog(null,"Ocorreu um Erro ao Salvar!!");
            }
        });
        
        // Ação do botão buscar
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomePaciente = buscaNomeField.getText();  // Pega o nome do campo de busca
                Paciente paciente = pacienteController.buscarPacientePorNome(nomePaciente);

                if (paciente != null) {
                    nomeField.setText(paciente.getNome());
                    dataNascimentoField.setText(paciente.getDataNascimento());
                    historicoMedicoField.setText(paciente.getHistoricoMedico());
                } else {
                    JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
                    nomeField.setText("");
                    dataNascimentoField.setText("");
                    historicoMedicoField.setText("");
                }
            }
        });
    }
}
