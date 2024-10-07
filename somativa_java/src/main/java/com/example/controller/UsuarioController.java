package com.example.controller;

import com.example.connection.FuncionarioDAO;
import com.example.model.Funcionario;

public abstract class UsuarioController {
    
    // Método de validação abstrato, sem implementação
    public abstract boolean validacao(String nome, String senha);

}
