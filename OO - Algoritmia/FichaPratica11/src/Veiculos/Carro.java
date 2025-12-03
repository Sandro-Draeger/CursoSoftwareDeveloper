package Veiculos;

import Veiculos.Enums.TipoCombustivel;

public class Carro extends Veiculo{
    private int qntPassageiros;

    public Carro(String marca, String modelo, String cor, int anoFabrico, int potencia, int cilindrada, TipoCombustivel tipoCombustivel, double consumoLitros, int qntPassageiros) {
        super(marca, modelo, cor, anoFabrico, potencia, cilindrada, consumoLitros, tipoCombustivel);
        this.qntPassageiros = qntPassageiros;
    }

    @Override
    public double calcularConsumo(double distancia) {
        double consumoFinal = (this.consumoLitros/100) * distancia;

        if(this.tipoCombustivel == TipoCombustivel.GASOLINA){
            consumoFinal *= 2.10;
            System.out.println("€"+consumoFinal+" em gasolina.");
        }
        if(this.tipoCombustivel == TipoCombustivel.DIESEL){
            consumoFinal *= 1.95;
            System.out.println("€"+consumoFinal+" em diesel.");
        }
        if(this.tipoCombustivel == TipoCombustivel.GPL){
            consumoFinal *= 1.15;
            System.out.println("€"+consumoFinal+" em GPL.");
        }
        if(this.tipoCombustivel == TipoCombustivel.ELETRICO){
            consumoFinal *= 0.12;
            System.out.println("€"+consumoFinal+" em elétrico.");
        }
        return consumoFinal;
    }
}
