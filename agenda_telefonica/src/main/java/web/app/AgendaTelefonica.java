package web.app;

public class AgendaTelefonica {

    private Contato[] contatos;
    private int contador;

    // construtor
    public AgendaTelefonica(int maxContatos) {
        contatos = new Contato[maxContatos];
        contador = 0;
    }

    // adicionar
    public void addContato(Contato contato) throws Exception {
        if (contador >= contatos.length) {
            throw new AgendaCheiaException("Agenda cheia!!!");
        }
        contatos[contador] = contato;
        contador++;
        System.out.println("Contato adicionado com sucesso");
    }

    // listar
    public void listarContato() {
        if (contador == 0) {
            System.out.println("Agenda Vazia");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }

    // buscar
    public Contato buscarContato(String nome) {
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                System.out.println(contatos[i].toString());
            }
        }
        return null;
    }

    // remover
    public void removerContato(String nome) throws Exception{
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i] = contatos[contador-1];
                contatos[contador-1] =null;
                contador--;
            System.out.println("Contador Removido com Sucesso");
            }
        }
        if (!encontrado) {
            throw new BuscarContatoException("Contato não Encontrado");
        }

    }
}
