package com.example.view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.controller.AdministradorController;
import com.example.controller.PacienteController;
import com.example.model.Paciente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class ClinicaFrame extends JFrame {
    private PacienteController pacienteController;
    private AdministradorController admController;
    private JTable pacientesTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private List<Paciente> pacientesList;

    // Campos de entrada
    private JTextField cpfField;
    private JTextField nomeField;
    private JFormattedTextField dataConsultaField;
    private JTextField telefoneField;
    private JTextField enderecoField;

    public ClinicaFrame(PacienteController controller, AdministradorController admController) {
        this.pacienteController = controller;
        this.admController = admController;
        setTitle("Gerenciamento de Pacientes");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para os campos de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10)); // Grade de 3 linhas e 2 colunas

        try {
            MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
            maskFormatter.setPlaceholderCharacter('_');
            cpfField = new JFormattedTextField(maskFormatter);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        nomeField = new JTextField();

        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_');
            dataConsultaField = new JFormattedTextField(maskFormatter);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        try {
            MaskFormatter maskFormatter = new MaskFormatter("(##)#####-####");
            maskFormatter.setPlaceholderCharacter('_');
            telefoneField = new JFormattedTextField(maskFormatter);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        enderecoField = new JTextField();

        // Criando Labels
        // Criando Labels
        JLabel cpfLabel = new JLabel("CPF:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel dataConsultaLabel = new JLabel("Data de Consulta:");
        JLabel telefoneLabel = new JLabel("Telefone:");
        JLabel enderecoLabel = new JLabel("Endereço:");

        // Atribuindo cor de texto para as labels
        cpfLabel.setForeground(Color.WHITE);
        nomeLabel.setForeground(Color.WHITE);
        dataConsultaLabel.setForeground(Color.WHITE);
        telefoneLabel.setForeground(Color.WHITE);
        enderecoLabel.setForeground(Color.WHITE);

        inputPanel.add(cpfLabel);
        inputPanel.add(cpfField);
        inputPanel.add(nomeLabel);
        inputPanel.add(nomeField);
        inputPanel.add(dataConsultaLabel);
        inputPanel.add(dataConsultaField);
        inputPanel.add(telefoneLabel);
        inputPanel.add(telefoneField);
        inputPanel.add(enderecoLabel);
        inputPanel.add(enderecoField);

        inputPanel.setBorder(BorderFactory.createEmptyBorder(100, 300, 20, 300));
        inputPanel.setBackground(Color.decode("#006465"));
        add(inputPanel, BorderLayout.NORTH); // Coloca o painel de inputs no topo

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Adicionar");
        JButton deleteButton = new JButton("Deletar");
        JButton editButton = new JButton("Editar");
        addButton.setBackground(Color.decode("#32CD32"));
        deleteButton.setBackground(Color.decode("#B22222"));
        deleteButton.setForeground(Color.WHITE);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);

        buttonPanel.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new LineBorder(Color.WHITE, 15)));
        buttonPanel.setBackground(Color.decode("#006465"));
        add(buttonPanel, BorderLayout.CENTER); // Coloca o painel de botões no centro

        // ================CRIANDO MENUBAR=================
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#06373d"));
        JMenu menu = new JMenu("| Entrar |");
        JMenu menuInfo = new JMenu("| Informações |");
        JMenu menuService = new JMenu("| Serviços |");
        JMenu menuFunc = new JMenu("| Funcionários |");
        menu.setForeground(Color.WHITE);
        menuInfo.setForeground(Color.WHITE);
        menuService.setForeground(Color.WHITE);
        menuFunc.setForeground(Color.WHITE);
        JMenuItem loginAdmItem = new JMenuItem("Entrar como Administrador");
        JMenuItem loginMedicoItem = new JMenuItem("Entrar como Médico");

        loginAdmItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdm loginAdm = new LoginAdm(admController);  
                loginAdm.setVisible(true); 
            }
        });


        menuBar.add(menu);
        menuBar.add(menuInfo);
        menuBar.add(menuService);
        menuBar.add(menuFunc);
        menu.add(loginAdmItem);
        menu.add(loginMedicoItem);
        setJMenuBar(menuBar);

        // Configuração da tabela
        String[] columnNames = { "CPF", "Nome", "Data Consulta", "Telefone", "Endereço" };
        tableModel = new DefaultTableModel(columnNames, 0);
        pacientesTable = new JTable(tableModel);
        scrollPane = new JScrollPane(pacientesTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Definindo a altura do scrollPane para ocupar metade da tela
        scrollPane.setPreferredSize(new Dimension(screenSize.width, screenSize.height / 2));

        add(scrollPane, BorderLayout.SOUTH); // Coloca a lista de pacientes na parte inferior

        // Ação do botão Adicionar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cpfField.getText().isEmpty() || nomeField.getText().isEmpty() ||
                        dataConsultaField.getText().isEmpty() || telefoneField.getText().isEmpty()
                        || enderecoField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    limparCampos();
                } else {
                    Paciente paciente = new Paciente();
                    paciente.setCpf(cpfField.getText());
                    paciente.setNome(nomeField.getText());
                    paciente.setDataConsulta(dataConsultaField.getText());
                    paciente.setTelefone(telefoneField.getText());
                    paciente.setEndereco(enderecoField.getText());

                    pacienteController.addPaciente(paciente);

                    // Limpar os campos após adicionar
                    limparCampos();
                    atualizarListaPacientes(); // Atualiza a lista na interface
                }
            }
        });

        // Ação do botão Deletar
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Paciente a deletar:");
                if (nome != null && !nome.isEmpty()) {
                    Paciente paciente = new Paciente();
                    paciente.setNome(nome);

                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja deletar o Paciente " + nome + "?", "",
                            JOptionPane.YES_NO_OPTION);
                    if (resposta == JOptionPane.YES_OPTION) {
                        pacienteController.deletarPaciente(paciente);
                        JOptionPane.showMessageDialog(null, "Paciente " + paciente.getNome() + "foi deletado!!!");
                        atualizarListaPacientes(); // Atualiza a lista na interface
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                }
            }
        });

        // Inicializa a lista de pacientes
        atualizarListaPacientes();
    }

    // Método para atualizar a lista de pacientes
    private void atualizarListaPacientes() {
        tableModel.setRowCount(0); // Limpa os dados atuais da tabela
        pacientesList = pacienteController.listarPacientes(); // Obtém a lista de pacientes

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

    // Método para limpar os campos após adicionar
    private void limparCampos() {
        cpfField.setText("");
        nomeField.setText("");
        dataConsultaField.setText("");
        telefoneField.setText("");
        enderecoField.setText("");
    }
}
