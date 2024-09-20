package web.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contato {
    
    // atributos
    private String nome;
    private String telefone;

    @Override
    public String toString(){
    return "nome: " + nome + "\ntelefone: " + telefone;
    }
}
