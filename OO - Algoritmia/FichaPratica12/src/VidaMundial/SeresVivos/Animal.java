package VidaMundial.SeresVivos;

import VidaMundial.Enums.Dieta;

public class Animal extends SerVivo{
    private boolean fome;
    private double peso;
    private double inteligencia;
    private Dieta alimentacao;
    private String barulho;

    public boolean isFome() {
        return fome;
    }

    public double getPeso() {
        return peso;
    }

    public double getInteligencia() {
        return inteligencia;
    }

    public Dieta getAlimentacao() {
        return alimentacao;
    }

    public String getBarulho() {
        return barulho;
    }

    public Animal(String nome, String especie, String pais, int idade, boolean fome, double peso, double inteligencia, Dieta alimentacao, String barulho) {
        super(nome, especie, pais, idade);
        this.fome = fome;
        this.peso = peso;
        this.inteligencia = inteligencia;
        this.alimentacao = alimentacao;
        this.barulho = barulho;

    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.print(this.fome+" | "+this.peso+"kg"+" | "+"Inteligencia: "+this.inteligencia+" | "+this.alimentacao);
    }
}
