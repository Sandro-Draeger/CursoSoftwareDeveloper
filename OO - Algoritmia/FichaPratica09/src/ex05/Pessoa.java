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

    public String getCidade() {
        return cidade;
    }

    public Pessoa(String nome, int idade, String cidade, String email, String telemovel) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.email = email;
        this.telemovel = telemovel;
    }

    public void exibirDetalhes(){
        System.out.print("\nNome: "+this.nome+" | ");
        System.out.print("idade: "+this.idade+" | ");
        System.out.print("Cidade: "+this.cidade+" | ");
        System.out.print("E-mail: "+this.email+" | ");
        System.out.print("Telemovel: "+this.telemovel);

    }


}
