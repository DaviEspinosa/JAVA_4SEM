package web.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Pessoa {
    // atributos
    private String nome;
    private int cpf;

    void exibirInformacoes() {

    }
}
