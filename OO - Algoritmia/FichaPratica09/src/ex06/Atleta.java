package ex06;

public class Atleta {
    private String nome;
    private String modalidadeDesportiva;
    private double altura;
    private double peso;
    private String paisOrigem;
    private int rankingMundial;

    public Atleta(String nome, String modalidadeDesportiva, double altura, double peso, String paisOrigem, int rankingMundial) {
        this.nome = nome;
        this.modalidadeDesportiva = modalidadeDesportiva;
        this.altura = altura;
        this.peso = peso;
        this.paisOrigem = paisOrigem;
        this.rankingMundial = rankingMundial;
    }

    public String getNome() {
        return nome;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void exibirDetalhes(){
        System.out.print("\nNome: "+this.nome+" | ");
        System.out.print("Modalidade: "+this.modalidadeDesportiva+" | ");
        System.out.print("Alt: "+this.altura+" | ");
        System.out.print("Peso: "+this.peso+" | ");
        System.out.print("Pais: "+this.paisOrigem+" | ");
        System.out.print("Ranking: "+this.rankingMundial+" | ");
    }
}
