package AirplaneStore.Avioes;

import java.util.ArrayList;

public class Catalogo extends Aviao{
    private ArrayList<Aviao> listaAvioes;

    public Catalogo(ArrayList<Aviao> listaAvioes) {
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

    public void exibirDetalhesCatalogo(){
        System.out.println("Aviões em Catálogo!:\n");
        for (int i = 0; i< listaAvioes.size(); i++){
            exibirDetalhes();
        }
    }
}
