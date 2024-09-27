package com.example;

import javax.swing.JFrame;

public class JanelaCalculadora extends JFrame {
    public JanelaCalculadora() {
        super("Calculadora");

        this.add(new TabbedPane());
        // set Frame
        this.pack();
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
    }
}
