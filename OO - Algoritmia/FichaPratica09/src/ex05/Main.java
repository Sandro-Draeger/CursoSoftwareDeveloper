package ex05;

public class Main {
    static void main() {
        Pessoa sandro = new Pessoa("Sandro", 29, "Blumenau", "sandro@gmail.com", "937181386");
        Pessoa leandro = new Pessoa("Leandro", 40, "Porto", "sandro@gmail.com", "934561387");
        Pessoa barbara = new Pessoa("Barbara", 31, "Gaia", "sandro@gmail.com", "93789389");
        Pessoa aricia = new Pessoa("Aricia", 30, "Sla", "sandro@gmail.com", "936981380");
        Pessoa marta = new Pessoa("Marta", 30, "Sla", "sandro@gmail.com", "936981380");

        Agenda alunos = new Agenda(4);

        alunos.adicionarPessoa(sandro);
        alunos.adicionarPessoa(aricia);

        System.out.println("\n_________________________________________\n");

        alunos.listarContatos();

        System.out.println("\n_________________________________________\n");

        alunos.adicionarPessoa(barbara);
        alunos.adicionarPessoa(leandro);

        System.out.println("\n_________________________________________\n");

        alunos.listarContatos();

        System.out.println("\n_________________________________________\n");

        alunos.pesquisarContacto("Porto");

        alunos.adicionarPessoa(aricia);


    }
}
