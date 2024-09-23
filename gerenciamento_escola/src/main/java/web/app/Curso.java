package web.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Curso {
    private List<Aluno> listAluno;
    private String nomeCurso;

    public Curso() {
        listAluno = new ArrayList<>();
    }

    public void addAluno(Aluno aluno) {
        listAluno.add(aluno);
    }

    public void listarAlunos() {
        if (listAluno.size() == 0) {
            JOptionPane.showMessageDialog(null, "Lista Vazia!!!");
        } else {
            for (Aluno aluno : listAluno) {
                JOptionPane.showMessageDialog(null, aluno);
            }
        }
    }

    public double calcularMediaNotaAlunos() {
        double mediaNotaAlunos = 0;
        if (listAluno.size() == 0) {
            return calcularMediaNotaAlunos();
        } else {
            for (Aluno aluno : listAluno) {
                mediaNotaAlunos += aluno.getNotas();
            }
            return mediaNotaAlunos / listAluno.size();
        }
    }
}
