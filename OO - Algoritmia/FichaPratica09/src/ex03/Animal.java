package ex03;

import java.util.Objects;

public class Animal {
    private String nome;
    private String especie;
    private String paisOrigem;
    private double peso;
    private String[] alimentacao;
    private ClasseReinoAnimal classeReinoAnimal;

    public Animal(String nome, String especie, String paisOrigem, double peso, String[] alimentacao, ClasseReinoAnimal classeReinoAnimal) {
        this.nome = nome;
        this.especie = especie;
        this.paisOrigem = paisOrigem;
        this.peso = peso;
        this.alimentacao = alimentacao;
        this.classeReinoAnimal = classeReinoAnimal;
    }

    public void fazerBarulho(){
        switch (classeReinoAnimal){
            case MAMÍFERO -> System.out.println("Tinoninon");
            case ANFÍBIO -> System.out.println("Brrrrrr");
            case AVE -> System.out.println("Kwak Kwak");
            case PEIXE -> System.out.println("Blub Blub Splash");
            case RÉPTIL -> System.out.println("Psssssss");
            default -> System.out.println("opção inválida");
        }
    }

    public void comer(String alimento, double pesoGramas){

        boolean comeu = false;
        for(int i = 0; i < alimentacao.length; i++){
            if (Objects.equals(alimento, alimentacao[i])){
                this.peso = this.peso + pesoGramas;
                comeu = true;
            }
        }
        if(comeu) {
            System.out.println("O " + this.especie + " " + this.nome + " comeu " + alimento);
            fazerBarulho();
        } else {
            System.out.println("O "+this.especie+" "+this.nome+" não comeu "+alimento);
        }
    }
    public void exibirDetalhes() {
        System.out.println(this.nome + " | "+this.especie + "\nPeso: "+this.peso);
    }
}
