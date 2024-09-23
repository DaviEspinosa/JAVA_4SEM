package web.app;

import javax.swing.JOptionPane;

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
    private double notas;

    @Override
    void exibirInformacoes() {
        // super.exibirInformacoes();
    
        String informacao = "Nome: "+getNome()+"\nCPF: "+getCpf()+"\nNota: "+getNotas()+"\nMatricula: "+getMatricula();

        JOptionPane.showMessageDialog(null, informacao, "Informações do Aluno", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
