package com.example.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.controller.AdministradorController;
import com.example.controller.FuncionarioController;
import com.example.controller.MedicoController;
import com.example.controller.PacienteController;

public class OptionFrame extends JFrame {

    private FuncionarioController funcionarioController;
    private MedicoController medicoController;
    private AdministradorController admController;
    private PacienteController pacienteController;
    private JButton admButton;
    private JButton funcionarioButton;
    private JButton medicoButton;

    public OptionFrame(AdministradorController admController, FuncionarioController funcionarioController, MedicoController medicoController, PacienteController pacienteController) {
        this.admController = admController;
        this.funcionarioController = funcionarioController;
        this.medicoController = medicoController;
        this.pacienteController = pacienteController;

        setTitle("Clínica Saúde");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Obtendo o tamanho do JFrame
        Dimension tamanhoJanela = this.getSize();
        int altura30Porcento = (int) (tamanhoJanela.height * 0.3);

        // Painéis superiores e inferiores
        JPanel panelVazioNorth = new JPanel();
        panelVazioNorth.setPreferredSize(new Dimension(tamanhoJanela.width, altura30Porcento));
        JPanel panelVazioSouth = new JPanel();
        panelVazioSouth.setPreferredSize(new Dimension(tamanhoJanela.width, altura30Porcento));

        // Painel central com GridLayout para os botões
        JPanel panelCenter = new JPanel(new GridLayout(3, 1, 10, 30));  // 3 linhas, 1 coluna, com espaçamento vertical
        panelCenter.setBorder(new EmptyBorder(40, 500, 40, 500));  // Espaçamento ao redor

        // Botões
        funcionarioButton = new JButton("Funcionário");
        medicoButton = new JButton("Médico");
        admButton = new JButton("Administrador");

        // Estilizando Botão
        funcionarioButton.setBackground(Color.decode("#006465"));
        medicoButton.setBackground(Color.decode("#006465"));
        admButton.setBackground(Color.decode("#006465"));
        funcionarioButton.setForeground(Color.WHITE);
        medicoButton.setForeground(Color.WHITE);
        admButton.setForeground(Color.WHITE);

        // Adicionar botões ao painel central
        panelCenter.add(funcionarioButton);
        panelCenter.add(medicoButton);
        panelCenter.add(admButton);

        // Adicionar os painéis ao frame
        this.add(panelVazioNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelVazioSouth, BorderLayout.SOUTH);

        // Ações dos botões
        funcionarioButton.addActionListener(e -> abrirFuncionarioLoginFrame());
        admButton.addActionListener(e -> abrirAdmLoginFrame());
        medicoButton.addActionListener(e -> abrirMedicoLoginFrame());
    }

    private void abrirFuncionarioLoginFrame() {
        LoginFuncionario loginFuncionario = new LoginFuncionario(funcionarioController);
        loginFuncionario.setVisible(true);
        this.dispose(); // Fecha a tela de login
    }

    private void abrirMedicoLoginFrame() {
        LoginMedico loginMedico = new LoginMedico(medicoController,pacienteController);
        loginMedico.setVisible(true);
        this.dispose(); // Fecha a tela de login
    }

    private void abrirAdmLoginFrame() {
        LoginAdm loginAdm = new LoginAdm(admController);
        loginAdm.setVisible(true);
        this.dispose(); // Fecha a tela de login
    }
}
