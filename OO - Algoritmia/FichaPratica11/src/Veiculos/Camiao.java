package Veiculos;

import Veiculos.Enums.TipoCombustivel;

public class Camiao extends Veiculo{
    private double capacidadeCarga;

    public Camiao(String marca, String modelo, String cor, int anoFabrico, int potencia, int cilindrada, double consumoLitro, TipoCombustivel tipoCombustivel, double capacidadeCarga) {
        super(marca, modelo, cor, anoFabrico, potencia, cilindrada, consumoLitro,tipoCombustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    public void viagem(double distancia, double carga) {
        if (carga > this.capacidadeCarga) {
            System.out.println("Carga superior à capacidade!");
            return;
        }
        double litrosBase = calcularConsumo(distancia);

        double aumentoConsumo100km = (carga / 100.0) * 0.1;

        double litrosExtra = (aumentoConsumo100km / 100.0) * distancia;

        double litrosTotais = litrosBase + litrosExtra;

        double custo = litrosTotais * 1.95;

        System.out.println("Consumo total: " + litrosTotais + " L");
        System.out.println("Custo total: " + custo + " €");
    }
}
