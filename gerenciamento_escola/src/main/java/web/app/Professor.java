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

public class Professor extends Pessoa{
    // atributos 
    private double salario;

    @Override
    void exibirInformacoes() {
        super.exibirInformacoes();
        String informacao = "Nome:"+getNome()+"\nCPF:"+getCpf()+"\nSalário:"+getSalario();
        JOptionPane.showMessageDialog(null,  informacao,"Informações do Professor",JOptionPane.INFORMATION_MESSAGE);
    }
}
