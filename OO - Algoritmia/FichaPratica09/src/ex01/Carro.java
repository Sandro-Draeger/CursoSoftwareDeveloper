package ex01;

import java.sql.SQLOutput;

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private int anoFabrico;
    private int potencia;
    private int cilindrada;
    private TipoCombustivel tipoCombustivel;
    private double consumoLitros;


    public Carro(String marca, String modelo, String cor, int anoFabrico, int potencia, int cilindrada, TipoCombustivel tipoCombustivel, double consumoLitros) {
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
        if (anoFabrico > (2025-30)) {
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

    public ResultadoCorrida corrida(Carro carroAdversario) {

        ResultadoCorrida resultado;

        if (this.potencia > carroAdversario.potencia) {
            resultado = ResultadoCorrida.VENCEU;
        } else if (this.potencia < carroAdversario.potencia) {
            resultado =  ResultadoCorrida.VENCE_ADVERSARIO;
        } else {
            if (this.cilindrada > carroAdversario.cilindrada) {
                resultado =  ResultadoCorrida.VENCEU;
            } else if (this.cilindrada < carroAdversario.cilindrada) {
                resultado =  ResultadoCorrida.VENCE_ADVERSARIO;
            } else {
                if (this.anoFabrico < carroAdversario.anoFabrico) {
                    resultado =  ResultadoCorrida.VENCEU;
                } else if (this.anoFabrico > carroAdversario.anoFabrico) {
                    resultado =  ResultadoCorrida.VENCE_ADVERSARIO;
                } else {
                    resultado =  ResultadoCorrida.EMPATE;
                }
            }
        }
        if (resultado == ResultadoCorrida.EMPATE){
            System.out.println("Houve um empate :?");
        } else if (resultado == ResultadoCorrida.VENCEU){
            System.out.println(this.marca+" " + this.modelo + " wins!");
        } else {
            System.out.println(carroAdversario.marca+" " + carroAdversario.modelo + " wins!");
        }

        return resultado;
    }

    public double calcularConsumo(double distancia) {
        this.consumoLitros = this.consumoLitros * distancia;

        return this.consumoLitros;
    }

    public void exibirDetalhes() {
        System.out.println(this.marca + " | "+this.modelo + " | "+this.anoFabrico);
    }
}
