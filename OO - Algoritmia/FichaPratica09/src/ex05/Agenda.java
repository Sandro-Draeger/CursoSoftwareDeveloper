package ex05;

public class Agenda {
    private int anoCriacao = 2025;
    private Pessoa[] listaContactos;

    public Agenda(int quantidadeContactos) {
        this.listaContactos = new Pessoa[quantidadeContactos];
    }

    public void adicionarPessoa(Pessoa pessoaNova) {
        boolean contem = false;
        for (int i = 0; i < this.listaContactos.length; i++) {
            if (this.listaContactos[i] == null) {
                listaContactos[i] = pessoaNova;
                i = this.listaContactos.length;

            } else if (this.listaContactos[i] == pessoaNova) {
                contem = true;
            }
        }
        if (contem) {
            System.out.println("Pessoa já se encontra nesta lista");
        } else {
            System.out.println("Adicionado com sucesso");
        }
    }


    public void listarContatos(){
        for (int i = 0; i<this.listaContactos.length; i++){
            System.out.println(this.listaContactos[i]);
        }
    }
    public void exibirDetalhes(){
        System.out.println("----- Lista de alunos -----");
        System.out.println("infos:");
        for (int i = 0; i<this.listaContactos.length; i++) {
            listaContactos[i].exibirDetalhes();

        }
    }
}
