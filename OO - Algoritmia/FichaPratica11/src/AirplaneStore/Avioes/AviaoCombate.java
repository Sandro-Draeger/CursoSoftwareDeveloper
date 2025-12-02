package AirplaneStore.Avioes;

public class AviaoCombate extends Aviao {
    private String paisOrigem;
    private boolean camuflagem;
    private Armas armas;

    public AviaoCombate(int serie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numMotores, double autonomia, double velocidadeMaxima, double preço) {
        super(serie, modelo, anoFabrico, peso, comprimentoFuselagem, envergaduraAsas, alturaCauda, numMotores, autonomia, velocidadeMaxima, preço);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
        this.armas = armas;
    }

    public void exibirDetalhes(){
        System.out.println(this.serie+" | "+this.modelo+" | "+this.anoFabrico+" | "+);
    }

}
