package web.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Aluno extends Pessoa {
    // atributos
    private String matricula;


    @Override
    void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Matricula:" +matricula);
    }
    
}
