package ex04;

public class Imovel {
    private String rua;
    private int numPorta;
    private String cidade;
    private Tipo tipo;
    private Acabamento acabamento;
    private double areaTotal;
    private double areaPiscina;
    private double numQuartos;
    private double numBanheiros;

    public Imovel(String rua, int numPorta, String cidade, Tipo tipo, Acabamento acabamento, double areaTotal, double areaPiscina, int numQuartos, int numBanheiros) {
        this.rua = rua;
        this.numPorta = numPorta;
        this.cidade = cidade;
        this.tipo = tipo;
        this.acabamento = acabamento;
        this.areaTotal = areaTotal;
        this.areaPiscina = areaPiscina;
        this.numQuartos = numQuartos;
        this.numBanheiros = numBanheiros;
    }

    public double calcularValor(){
    double valorBase = 0;
    switch (tipo){
        case APARTAMENTO -> valorBase = this.areaTotal * 1000;
        case CASA -> valorBase = this.areaTotal * 3000;
        case MANSAO -> valorBase = this.areaTotal * 5000;
    }
        valorBase = valorBase + (this.numQuartos * 7500);
        valorBase = valorBase + (this.numBanheiros * 10500);
        valorBase = valorBase + (this.areaPiscina * 1000);

    switch (acabamento){
        case PARA_RESTAURO -> valorBase = valorBase - (valorBase * 0.5);
        case USADA -> valorBase = valorBase - (valorBase * 0.1);
        case NOVA -> valorBase = valorBase;
        case NOVA_COM_ALTO_ACABAMENTO -> valorBase = valorBase + (valorBase * 0.25);
    }
    return valorBase;
    }

    public Imovel compararImoveis(Imovel imovelComparativo){
        double valorImovel01 = this.calcularValor();
        double valorImovel02 = imovelComparativo.calcularValor();

        if(valorImovel01<valorImovel02) {
            System.out.println(this.rua+" é o mais caro");
            return imovelComparativo;
        } else {
            System.out.println(this.rua+" é o mais caro");
            return this;
        }
    }

    public void exibirDetalhes() {
        System.out.println(this.rua + " | "+this.cidade);
    }
}
