package ex03;

public class Peixe {
    private String especie;
    private double peso;
    private double preco;

    public Peixe(String especie, double peso, double preco) {
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
    public void exibirDetalhesPeixe(){
        System.out.println(especie+" | "+peso+"kg"+" | "+"€"+preco);
    }
}
