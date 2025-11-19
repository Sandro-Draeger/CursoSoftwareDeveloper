package ex05;

public class Agenda {
    private int anoCriacao = 2025;
    private Pessoa[] listaContactos;

    public Agenda(int quantidadeContactos) {
        this.listaContactos = new Pessoa[quantidadeContactos];
    }

    public void adicionarPessoa(Pessoa pessoaNova) {
        for (int i = 0; i < this.listaContactos.length; i++) {
            if (this.listaContactos[i] == null) {
                listaContactos[i] = pessoaNova;
                System.out.println(pessoaNova.getNome() + " adicionado com sucesso");
                return;
            }
        }
        System.out.println(pessoaNova.getNome() + " já se encontra nesta lista");
    }


    public void listarContatos() {
        exibirDetalhes();
    }

    public void exibirDetalhes() {
        System.out.println("\n----- Lista de alunos -----");
        for (int i = 0; i < this.listaContactos.length; i++) {
            if (listaContactos[i] != null) {
                listaContactos[i].exibirDetalhes();
            }
        }
    }

    public void pesquisarContacto(String cidade) {
        for (int i = 0; i < this.listaContactos.length; i++) {
            if (this.listaContactos[i].getCidade().equals(cidade)) {
                listaContactos[i].exibirDetalhes();
            }
        }
    }
}
