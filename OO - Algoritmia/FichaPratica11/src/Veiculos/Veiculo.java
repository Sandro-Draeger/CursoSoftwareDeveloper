package Veiculos;

import Veiculos.Enums.TipoCombustivel;

public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected String cor;
    protected int anoFabrico;
    protected int potencia;
    protected int cilindrada;
    protected TipoCombustivel tipoCombustivel;
    protected double consumoLitros;


    public Veiculo(String marca, String modelo, String cor, int anoFabrico, int potencia, int cilindrada, double consumoLitros, TipoCombustivel tipoCombustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.anoFabrico = anoFabrico;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.tipoCombustivel = tipoCombustivel;
        this.consumoLitros = consumoLitros;
    }

    public void ligarCarro() {
        if (anoFabrico > (2025 - 30)) {
            if (this.tipoCombustivel == TipoCombustivel.DIESEL) {
                System.out.println("Deita um pouco de fumo... Custa a pegar...O carro está ligado!");
                System.out.println("Vrum-vrum-vrum");
            } else {
                System.out.println("Custa a pegar.. O carro está ligado!");
                System.out.println("Vrum-vrum-vrum");
            }
        } else {
            if (potencia >= 250) {
                System.out.println("O carro está ligado!");
                System.out.println("VRUMMMMMMM");
            } else {
                System.out.println("O carro está ligado!");
                System.out.println("Vrummmm");
            }
        }
    }

    public Veiculo corrida(Veiculo adversario) {

        if (this.potencia > adversario.potencia) {
            // Ganha o meu carro
            return this;
        } else if (this.potencia < adversario.potencia) {
            // Ganha o adversario
            return adversario;
        } else {
            // Empate - PotenciaCv

            if (this.cilindrada > adversario.cilindrada) {
                // Ganha o meu carro
                return this;
            } else if (this.cilindrada < adversario.cilindrada) {
                // Ganha o adversario
                return adversario;
            } else {

                // Empate - cilindrada

                if (this.anoFabrico > adversario.anoFabrico) {
                    // Ganha o meu carro
                    return this;
                } else if (this.anoFabrico < adversario.anoFabrico) {
                    // Ganha o adversario
                    return adversario;
                } else {
                    // Empate
                    return null;
                }

            }
        }
    }


    public void exibirDetalhes() {
        System.out.println(this.marca + " | " + this.modelo + " | " + this.anoFabrico);
    }

    public double calcularConsumo(double distancia) {
        return (this.consumoLitros / 100.0) * distancia;
    }


}