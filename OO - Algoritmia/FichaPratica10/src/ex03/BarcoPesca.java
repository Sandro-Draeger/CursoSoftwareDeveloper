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

    public BarcoPesca(String nome, String cor, String anoFabrico, int tripulacao, double capacidadeCarga, Marca marca) {
        this.nome = nome;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.tripulacao = tripulacao;
        this.capacidadeCarga = capacidadeCarga;
        this.marca = marca;
        this.peixesPescados = new ArrayList<>();
        this.mariscosPescados = new ArrayList<>();
    }

    public void pescarPeixe(Peixe peixeAtual) {
        double pesoSomaPeixe = 0;
        double pesoSomaMarisco = 0;

        for (Peixe peixe : peixesPescados) {
            pesoSomaPeixe += peixe.getPeso();
        }
        for (Marisco marisco : mariscosPescados) {
            pesoSomaMarisco += marisco.getPeso();
        }
        if (this.capacidadeCarga >= peixeAtual.getPeso() + pesoSomaPeixe + pesoSomaMarisco) {
            this.peixesPescados.add(peixeAtual);
            System.out.println(peixeAtual.getEspecie() + " pescado!");
        } else {
            System.out.println("Não cabe no barco!");
        }
    }

    public void pescarMarisco(Marisco mariscoAtual) {
        double pesoSomaPeixe = 0;
        double pesoSomaMarisco = 0;

        for (Peixe peixe : peixesPescados) {
            pesoSomaPeixe += peixe.getPeso();
        }
        for (Marisco marisco : mariscosPescados) {
            pesoSomaMarisco += marisco.getPeso();
        }
        if (this.capacidadeCarga >= mariscoAtual.getPeso() + pesoSomaMarisco + pesoSomaPeixe) {
            this.mariscosPescados.add(mariscoAtual);
            System.out.println(mariscoAtual.getEspecie() + " pescado!");
        } else {
            System.out.println("Não cabe no barco!");
        }
    }

    public void largarPeixe(Peixe peixeAtual) {
        this.peixesPescados.remove(peixeAtual);
        System.out.println(peixeAtual.getEspecie() + " largado!");
    }

    public void largarMarisco(Marisco mariscoAtual) {
        this.mariscosPescados.remove(mariscoAtual);
        System.out.println(mariscoAtual.getEspecie() + " largado!");
    }

    public double calcularTotal() {
        double precoTotalPeixes = 0;
        double precoTotalMariscos = 0;
        double precoTotal = 0;

        for (int i = 0; i < peixesPescados.size(); i++) {
            precoTotalPeixes += peixesPescados.get(i).getPreco() * peixesPescados.get(i).getPeso();
        }
        for (int i = 0; i < mariscosPescados.size(); i++) {
            precoTotalMariscos += mariscosPescados.get(i).getPreco() * peixesPescados.get(i).getPeso();
        }
        precoTotal = precoTotalMariscos + precoTotalPeixes;
        System.out.println("\nTotal pescado: €" + precoTotal);

        return  precoTotal;
    }


    public void exebirDetalhes() {
        System.out.println("\n******** Barco " + nome + "********");
        System.out.println("Peixes:");
        for (int i = 0; i < peixesPescados.size(); i++) {
            peixesPescados.get(i).exibirDetalhesPeixe();
        }
        System.out.println("\nMariscos:");
        for (int i = 0; i < mariscosPescados.size(); i++) {
            mariscosPescados.get(i).exibirDetalhesMarisco();
        }
    }

    public double salarioTripulacao(){
        double valorTotal = calcularTotal();
        double salarioTripulacao;

        salarioTripulacao = (valorTotal-(valorTotal*0.40))/this.tripulacao;
        System.out.println("Salario de cada tripulante: "+salarioTripulacao);
        return salarioTripulacao;
    }
}
