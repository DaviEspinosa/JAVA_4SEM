package com.example;

import javax.swing.*;

public class TabbedPane extends JPanel {
    public TabbedPane() {
        super();    

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Calculadora Simples", new CalculadoraSimples());
        tabbedPane.addTab("Calculadora Científica", new CalculadoraCientifica());

        // Adiciona o JTabbedPane ao JPanel
        this.add(tabbedPane);
    }
}
