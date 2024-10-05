package com.example.view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import com.example.controller.PacienteController;
import com.example.model.Paciente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ClinicaFrame extends JFrame {
    private PacienteController pacienteController;
    private JPanel pacienteListPanel;

    // Campos de entrada
    private JTextField cpfField;
    private JTextField nomeField;
    // private JTextField historicoMedicoField;
    private JFormattedTextField dataNascimentoField;
    private JTextField telefoneField;
    private JTextField enderecoField;

    public ClinicaFrame(PacienteController controller) {
        this.pacienteController = controller;
        setTitle("Gerenciamento de Pacientes");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para os campos de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10)); // Grade de 3 linhas e 2 colunas

        cpfField = new JTextField();
        nomeField = new JTextField();
        // historicoMedicoField = new JTextField();

        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_');
            dataNascimentoField = new JFormattedTextField(maskFormatter);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        telefoneField = new JTextField();
        enderecoField = new JTextField();

        // Criando Labels
        JLabel cpfLabel = new JLabel("CPF:");
        JLabel nomeLabel = new JLabel("Nome:");
        // JLabel historicoMedicoLabel = new JLabel("Histórico Médico:");
        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
        JLabel telefoneLabel = new JLabel("Telefone:");
        JLabel enderecoLabel = new JLabel("Endereço:");

        // Atribuindo cor de texto para as labels
        cpfLabel.setForeground(Color.WHITE);
        nomeLabel.setForeground(Color.WHITE);
        // historicoMedicoLabel.setForeground(Color.WHITE);
        dataNascimentoLabel.setForeground(Color.WHITE);
        telefoneLabel.setForeground(Color.WHITE);
        enderecoLabel.setForeground(Color.WHITE);

        inputPanel.add(cpfLabel);
        inputPanel.add(cpfField);
        inputPanel.add(nomeLabel);
        inputPanel.add(nomeField);
        // inputPanel.add(new JLabel("Histórico Médico:"));
        // inputPanel.add(historicoMedicoField);
        inputPanel.add(dataNascimentoLabel);
        inputPanel.add(dataNascimentoField);
        inputPanel.add(telefoneLabel);
        inputPanel.add(telefoneField);
        inputPanel.add(enderecoLabel);
        inputPanel.add(enderecoField);
        //adicionando emptyborder        
        inputPanel.setBorder(BorderFactory.createEmptyBorder(100, 400, 20, 500));
        inputPanel.setBackground(Color.decode("#08281f"));
        add(inputPanel, BorderLayout.NORTH); // Coloca o painel de inputs no topo

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Adicionar");
        JButton deleteButton = new JButton("Deletar");
        JButton editButton = new JButton("Editar");
        addButton.setBackground(Color.decode("#32CD32"));
        // addButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.decode("#B22222"));
        deleteButton.setForeground(Color.WHITE);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        EmptyBorder paddingBorderButtonPanel = new EmptyBorder(0,0,0,0);
        LineBorder lineBorderButtonPanel = new LineBorder(Color.WHITE);
        buttonPanel.setBorder(new CompoundBorder(paddingBorderButtonPanel, lineBorderButtonPanel));
        buttonPanel.setBackground(Color.decode("#08281f"));
        add(buttonPanel, BorderLayout.CENTER); // Coloca o painel de botões no centro

        // Painel para lista de pacientes
        pacienteListPanel = new JPanel();
        pacienteListPanel.setLayout(new BoxLayout(pacienteListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(pacienteListPanel);
        add(scrollPane, BorderLayout.SOUTH); // Coloca a lista de pacientes na parte inferior

        // Ação do botão Adicionar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cpfField.getText().isEmpty() || nomeField.getText().isEmpty() ||
                    // historicoMedicoField.getText().isEmpty()
                    dataNascimentoField.getText().isEmpty() ||
                    telefoneField.getText().isEmpty() || enderecoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                        limparCampos();
                } else {
                    Paciente paciente = new Paciente();
                    paciente.setCpf(cpfField.getText());
                    paciente.setNome(nomeField.getText());
                    // paciente.setHistoricoMedico(historicoMedicoField.getText());
                    paciente.setDataNascimento(dataNascimentoField.getText());
                    paciente.setTelefone(telefoneField.getText());
                    paciente.setEndereco(enderecoField.getText());

                    pacienteController.addPaciente(paciente);

                    // Limpar os campos após adicionar
                    limparCampos();
                    atualizarListaPacientes();
                }
            }
        });

        // Ação do botão Deletar (simplesmente deleta pelo nome como antes)
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Paciente a deletar:");
                if (nome != null && !nome.isEmpty()) {
                    Paciente paciente = new Paciente();
                    paciente.setNome(nome);
                    pacienteController.deletarPaciente(paciente);
                    atualizarListaPacientes();
                }
            }
        });

        // Inicializa a lista de pacientes
        atualizarListaPacientes();
    }

    // Método para atualizar a lista de pacientes
    private void atualizarListaPacientes() {
        pacienteListPanel.removeAll(); // Limpa os componentes atuais
        pacienteController.listarPaciente(pacienteListPanel); // Preenche com a tabela atualizada
        pacienteListPanel.revalidate(); // Atualiza a interface
        pacienteListPanel.repaint(); // Repinta para garantir que os novos dados sejam exibidos
    }

    // Método para limpar os campos após adicionar
    private void limparCampos() {
        cpfField.setText("");
        nomeField.setText("");
        // historicoMedicoField.setText("");
        dataNascimentoField.setText("");
        telefoneField.setText("");
        enderecoField.setText("");
    }
}
