package com.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.example.controller.AdministradorController;
import com.example.controller.FuncionarioController;
import com.example.controller.MedicoController;
import com.example.controller.PacienteController;
import com.example.model.Funcionario;
import com.example.model.Medico;

public class ClinicaFrameADM extends JFrame {
    private AdministradorController administradorController;
    private PacienteController pacienteController;
    private FuncionarioController funcionarioController;
    private MedicoController medicoController;
    private Funcionario funcionario;
    private Medico medico;
    // Campos do formulário
    private JTextField nomeField;
    private JPasswordField senhaField;
    private JTextField nomeMedicoField;
    private JPasswordField senhaMedicoField;
    

    public ClinicaFrameADM(FuncionarioController funcionarioController, MedicoController medicoController, PacienteController pacienteController, AdministradorController administradorController) {
        this.funcionarioController = funcionarioController;
        this.medicoController = medicoController;
        this.pacienteController = pacienteController;
        this.administradorController = administradorController;
        setTitle("Cadastro de Usuário");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel superior para o formulário de cadastro
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Funcionário"));

        nomeField = new JTextField(20);
        senhaField = new JPasswordField(20);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBackground(Color.decode("#006465"));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFocusPainted(false);

        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);
        formPanel.add(new JLabel("Senha:"));
        formPanel.add(senhaField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(cadastrarButton);
        formPanel.add(new JLabel()); // Espaço vazio para alinhamento
        formPanel.add(buttonPanel);

        add(formPanel, BorderLayout.NORTH);

        // =-=-=-=-=-FORMULARIO MEDICO=-=-=-=-=-

        JPanel formMedicoPanel = new JPanel();
        formMedicoPanel.setLayout(new GridLayout(3, 2, 10, 10));
        formMedicoPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Médico"));

        nomeMedicoField = new JTextField(20);
        senhaMedicoField = new JPasswordField(20);

        JButton cadastrarMedicoButton = new JButton("Cadastrar");
        cadastrarMedicoButton.setBackground(Color.decode("#006465"));
        cadastrarMedicoButton.setForeground(Color.WHITE);
        cadastrarMedicoButton.setFocusPainted(false);

        formMedicoPanel.add(new JLabel("Nome:"));
        formMedicoPanel.add(nomeMedicoField);
        formMedicoPanel.add(new JLabel("Senha:"));
        formMedicoPanel.add(senhaMedicoField);

        JPanel buttonMedicoPanel = new JPanel(new FlowLayout());
        buttonMedicoPanel.add(cadastrarMedicoButton);
        formMedicoPanel.add(new JLabel()); // Espaço vazio para alinhamento
        formMedicoPanel.add(buttonMedicoPanel);

        JPanel panelVazio = new JPanel();
        panelVazio.setPreferredSize(new Dimension(500,380));
        add(formMedicoPanel, BorderLayout.CENTER);
        add(panelVazio, BorderLayout.SOUTH);

                // ================CRIANDO MENUBAR=================
                JMenuBar menuBar = new JMenuBar();
                menuBar.setBackground(Color.decode("#06373d"));
                JMenu menu = new JMenu("| Opções |");
                menu.setForeground(Color.WHITE);
                JMenuItem voltarItem = new JMenuItem("Voltar");
                JMenuItem contatosItem = new JMenuItem("Contatos");
        
                voltarItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OptionFrame optionFrame = new OptionFrame(administradorController, funcionarioController, medicoController,
                                pacienteController);
                        optionFrame.setVisible(true);
                        fecharJanela();
                    }
                });
        
                menuBar.add(menu);
                menu.add(voltarItem);
                menu.add(contatosItem);
                setJMenuBar(menuBar);

        // Ação do botão cadastrar
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFuncionario();
            }
        });

        cadastrarMedicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMedico();
            }
        });

    }

    private void cadastrarFuncionario() {
        String nome = nomeField.getText();
        String senha = new String(senhaField.getPassword());

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        // Cria um novo objeto Funcionario
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setSenha(senha);

        // Chama o método de cadastro no controller
        funcionarioController.cadastrar(funcionario);

        // Exibe mensagem de sucesso e limpa os campos
        JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
        nomeField.setText("");
        senhaField.setText("");
    }
    
    private void cadastrarMedico() {
        String nome = nomeMedicoField.getText();
        String senha = new String(senhaMedicoField.getPassword());

        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            return;
        }

        // Cria um novo objeto Funcionario
        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setSenha(senha);

        // Chama o método de cadastro no controller
        medicoController.cadastrar(medico);

        // Exibe mensagem de sucesso e limpa os campos
        JOptionPane.showMessageDialog(this, "Médico cadastrado com sucesso!");
        nomeMedicoField.setText("");
        senhaMedicoField.setText("");
    }

    private void fecharJanela(){
        this.dispose(); // Fecha a tela de login
    }
}
