package com.example.view;

import javax.swing.*;
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

    public ClinicaFrame(PacienteController controller) {
        this.pacienteController = controller;
        setTitle("Gerenciamento de Pacientes");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// Pegando todo o tamanho da tela
        setSize(screenSize.width, screenSize.height);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Adicionar");
        JButton deleteButton = new JButton("Deletar");
        JButton editButton = new JButton("Editar");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente paciente = new Paciente();
                paciente.setNome(JOptionPane.showInputDialog("Nome do Paciente:"));
                paciente.setCpf(JOptionPane.showInputDialog("CPF do Paciente:"));


                
                // Campo formatado para Data de Nascimento
                JFormattedTextField dataNascimentoField = null;
                try {
                    // Máscara para Data de Nascimento (dd/MM/yyyy)
                    MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
                    maskFormatter.setPlaceholderCharacter('_');
                    dataNascimentoField = new JFormattedTextField(maskFormatter);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                dataNascimentoField.setValue(""); // Valor inicial em branco
                int result = JOptionPane.showConfirmDialog(null, dataNascimentoField, "Data de Nascimento do Paciente:",
                        JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    paciente.setDataNascimento(dataNascimentoField.getText());
                }



                paciente.setTelefone(JOptionPane.showInputDialog("Telefone do Paciente:"));
                paciente.setEndereco(JOptionPane.showInputDialog("Endereço do Paciente:"));
                pacienteController.addPaciente(paciente);

                // Atualiza a lista após adicionar
                atualizarListaPacientes();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Paciente a deletar:");
                Paciente paciente = new Paciente();
                paciente.setNome(nome);
                pacienteController.deletarPaciente(paciente);

                // Atualiza a lista após deletar
                atualizarListaPacientes();
            }
        });

        // Implementação de edição pode ser feita aqui futuramente

        add(buttonPanel, BorderLayout.NORTH);
        pacienteListPanel = new JPanel();
        int panelListHeight = (int) (screenSize.height * 0.7);
        int panelListWidth = (int) (screenSize.width * 0.7);
        pacienteListPanel.setPreferredSize(new Dimension(panelListWidth, panelListHeight));
        pacienteListPanel.setLayout(new BoxLayout(pacienteListPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(pacienteListPanel);
        add(scrollPane, BorderLayout.CENTER);

        atualizarListaPacientes();
    }

    // Método para atualizar a lista de pacientes
    private void atualizarListaPacientes() {
        pacienteListPanel.removeAll(); // Limpa os componentes atuais
        pacienteController.listarPaciente(pacienteListPanel); // Preenche com a tabela atualizada
        pacienteListPanel.revalidate(); // Atualiza a interface
        pacienteListPanel.repaint(); // Repinta para garantir que os novos dados sejam exibidos
    }
}
