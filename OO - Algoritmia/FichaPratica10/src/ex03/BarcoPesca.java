package ex03;

import java.util.ArrayList;

public class BarcoPesca {
    private String nome;
    private String cor;
    private String anoFabrico;
    private int tripulacao;
    private double capacidadeCarga;
    private Marca marca;
    private ArrayList<Peixe> peixesPescados;
    private ArrayList<Marisco> mariscosPescados;

    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCarga, Marca marca, ArrayList<Peixe> peixesPescados, ArrayList<Marisco> mariscosPescados) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
        this.peixesPescados = new ArrayList<>();
        this.mariscosPescados = new ArrayList<>();
    }

    public void pescarPeixe(Peixe peixeAtual){
        this.peixesPescados.add(peixeAtual);
    }

    public void pescarMarisco(Marisco mariscoAtual){
        this.mariscosPescados.add(mariscoAtual);
    }
}
