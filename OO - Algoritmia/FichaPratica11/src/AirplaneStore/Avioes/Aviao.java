package AirplaneStore.Avioes;

public abstract class Aviao {
    protected int serie;
    protected String modelo;
    protected int anoFabrico;
    protected double peso;
    protected double comprimentoFuselagem;
    protected double envergaduraAsas;
    protected double alturaCauda;
    protected int numMotores;
    protected double autonomia;
    protected double velocidadeMaxima;
    protected double preço;

    public Aviao(int serie, String modelo, int anoFabrico, double peso, double comprimentoFuselagem, double envergaduraAsas, double alturaCauda, int numMotores, double autonomia, double velocidadeMaxima, double preço) {
        this.serie = serie;
        this.modelo = modelo;
        this.anoFabrico = anoFabrico;
        this.peso = peso;
        this.comprimentoFuselagem = comprimentoFuselagem;
        this.envergaduraAsas = envergaduraAsas;
        this.alturaCauda = alturaCauda;
        this.numMotores = numMotores;
        this.autonomia = autonomia;
        this.velocidadeMaxima = velocidadeMaxima;
        this.preço = preço;
    }

    protected Aviao() {
    }

    public int getSerie() {
        return serie;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabrico() {
        return anoFabrico;
    }

    public double getPeso() {
        return peso;
    }

    public double getComprimentoFuselagem() {
        return comprimentoFuselagem;
    }

    public double getEnvergaduraAsas() {
        return envergaduraAsas;
    }

    public double getAlturaCauda() {
        return alturaCauda;
    }

    public int getNumMotores() {
        return numMotores;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public double getPreço() {
        return preço;
    }

    public void exibirDetalhes(){
        System.out.println(this.serie+" | "+this.modelo+" | "+this.anoFabrico+" | "+this.preço);
    }
}

