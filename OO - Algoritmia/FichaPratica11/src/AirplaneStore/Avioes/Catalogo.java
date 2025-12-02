package AirplaneStore.Avioes;

import java.util.ArrayList;

public class Catalogo extends Aviao{
    private ArrayList<Aviao> listaAvioes;

    public Catalogo(int serie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numMotores, double autonomia, double velocidadeMaxima, double preço, ArrayList<Aviao> listaAvioes) {
        super(serie, modelo, anoFabrico, peso, comprimentoFuselagem, envergaduraAsas, alturaCauda, numMotores, autonomia, velocidadeMaxima, preço);
        this.listaAvioes = listaAvioes;
    }

    public void adquirirAvioes(Aviao novoAviao){
        this.listaAvioes.add(novoAviao);
        System.out.println(this.modelo + " adicionado ao Catálogo.");
    }

    public void venderAvioes(Aviao aviaoVendido){
        this.listaAvioes.remove(aviaoVendido);
        System.out.println(this.modelo + " vendido!");
    }

    public void calcularTotal(){
        double valorTotal = 0;
        for(int i = 0; i<this.listaAvioes.size(); i++){
            valorTotal += this.getPreço();
        }
        System.out.println("€" + valorTotal);
    }

    public void exebirDetalhesCatalogo(){
        System.out.println();
    }
}
