package ex03;

public class Marisco {
    private String especie;
    private double peso;
    private double preco;

    public Marisco(String especie, double peso, double preco) {
        this.especie = especie;
        this.peso = peso;
        this.preco = preco;
    }

    public String getEspecie() {
        return especie;
    }

    public double getPeso() {
        return peso;
    }

    public double getPreco() {
        return preco;
    }

    public void exibirDetalhesMarisco(){
        System.out.println(especie+" | "+peso+" | "+"€"+preco);
    }
}
