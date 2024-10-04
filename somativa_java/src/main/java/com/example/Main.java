package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.controller.PacienteController;
import com.example.view.ClinicaFrame;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        PacienteController controller = new PacienteController();
        ClinicaFrame frame = new ClinicaFrame(controller);
        frame.setVisible(true);
    }
}