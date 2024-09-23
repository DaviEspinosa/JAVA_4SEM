package web.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {
    // atributos
    private String nome;
    private int idade;
    private double salario;

    @Override
    public String toString(){
        return "Nome: "+nome+", Idade:"+idade+", Salário:"+salario;
    }
}
