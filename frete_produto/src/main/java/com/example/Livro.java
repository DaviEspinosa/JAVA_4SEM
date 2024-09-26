package com.example;

import java.util.List;

public class Livro extends Produto implements Transportavel {
    
    @Override
    public double calcularFrete() {
        return 5;
    }

    @Override
    public double calcularPeso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPeso'");
    }

}
