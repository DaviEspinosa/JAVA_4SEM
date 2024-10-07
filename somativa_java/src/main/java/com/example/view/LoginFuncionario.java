package com.example.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.controller.AdministradorController;
import com.example.controller.FuncionarioController;

public class LoginFuncionario extends JFrame {

    private FuncionarioController funcController;
    private AdministradorController admController;
    private JTextField nameField;
    private JPasswordField senhaField;
    private JLabel nameLabel;
    private JLabel senhaLabel;
    private JButton loginButton;
    private JLabel vazioLabel;

    public LoginFuncionario(FuncionarioController funcionarioController) {
        this.funcController = funcionarioController;
        setTitle("Login Funcionário");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Obtendo o tamanho do JFrame
        Dimension tamanhoJanela = this.getSize();

        // Calculando 30% da altura
        int altura30Porcento = (int) (tamanhoJanela.height * 0.3);

        JPanel panelVazioNorth = new JPanel();
        panelVazioNorth.setBackground(Color.decode("#006465"));
        panelVazioNorth.setPreferredSize(new Dimension(tamanhoJanela.width, altura30Porcento));
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(6, 3, 0,0));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(50,500,50,500));
        panelCenter.setBackground(Color.decode("#006465"));
        JPanel panelVazioSouth = new JPanel();
        panelVazioSouth.setBackground(Color.decode("#006465"));
        panelVazioSouth.setPreferredSize(new Dimension(tamanhoJanela.width, altura30Porcento));

        nameField = new JTextField(20);
        senhaField = new JPasswordField(20);
        nameLabel = new JLabel("Nome:");
        nameLabel.setForeground(Color.white);
        senhaLabel = new JLabel("Senha:");
        senhaLabel.setForeground(Color.white);
        loginButton = new JButton("Login");
        loginButton.setForeground(Color.white);
        loginButton.setBackground(Color.decode("#170b2a"));
        vazioLabel = new JLabel(" ");

        panelCenter.add(nameLabel);
        panelCenter.add(nameField);
        panelCenter.add(vazioLabel);
        panelCenter.add(vazioLabel);
        panelCenter.add(senhaLabel);
        panelCenter.add(senhaField);
        panelCenter.add(vazioLabel);
        panelCenter.add(vazioLabel);
        panelCenter.add(loginButton);

        this.add(panelVazioNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelVazioSouth, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String nome = nameField.getText();
            String senha = new String(senhaField.getPassword());

            // Validação de login
            if (funcController.validacao(nome, senha)) {
                // Login bem-sucedido
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                abrirClinicaFrame(); // Chamar o método para abrir a próxima janela
            } else {
                // Falha no login
                JOptionPane.showMessageDialog(this, "Nome ou senha incorretos. Tente novamente.", "Erro de Login",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Método para abrir o ClinicaFrame após login bem-sucedido
    private void abrirClinicaFrame() {
        ClinicaFrame clinicaFrame = new ClinicaFrame(funcController.getpPacienteController(), admController);
        clinicaFrame.setVisible(true);
        this.dispose(); // Fecha a tela de login
    }

}