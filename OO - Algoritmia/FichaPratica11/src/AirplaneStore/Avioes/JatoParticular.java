package AirplaneStore.Avioes;

import AirplaneStore.Enums.Categoria;
import AirplaneStore.Enums.Instalacoes;

public class JatoParticular extends Aviao {
    private int lotacao;
    private double capacidadeBagagem;
    private Categoria categoria;
    private Instalacoes instalacoes;


    public JatoParticular(int serie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numMotores, double autonomia, double velocidadeMaxima, double preço, int lotacao, double capacidadeBagagem, Categoria categoria, Instalacoes intalacoes) {
        super(serie, modelo, anoFabrico, peso, comprimentoFuselagem, envergaduraAsas, alturaCauda, numMotores, autonomia, velocidadeMaxima, preço);
        this.lotacao = lotacao;
        this.capacidadeBagagem = capacidadeBagagem;
        this.categoria = categoria;
        this.instalacoes = intalacoes;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println(this.lotacao+" | "+this.categoria+" | "+this.instalacoes);
    }
}

