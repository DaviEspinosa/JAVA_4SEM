package com.example;

import com.example.controller.PacienteController;
import com.example.view.ClinicaFrame;

public class Main {
    public static void main(String[] args) {
        PacienteController controller = new PacienteController();
        ClinicaFrame frame = new ClinicaFrame(controller);
        frame.setVisible(true);
    }
}
