package ex05;

public class Pessoa {
    private String nome;
    private int idade;
    private String cidade;
    private String email;
    private String telemovel;

    public String getNome() {
        return nome;
    }

    public Pessoa(String nome, int idade, String cidade, String email, String telemovel) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    public void exibirDetalhes(){
        System.out.println("----- Info -----");
        System.out.println("Nome: "+this.nome);
        System.out.println("idade: "+this.idade);
        System.out.println("Cidade: "+this.cidade);
        System.out.println("E-mail: "+this.email);
        System.out.println("Telemovel: "+this.telemovel);

    }


}
