package Veiculos;

import Veiculos.Enums.TipoCombustivel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static void main() throws FileNotFoundException {
        Carro carro1 = new Carro(
                "BMW", "Série 1", "Preto", 2020, 140, 1600,
                TipoCombustivel.ELETRICO, 6.5, 5
        );

        Carro carro2 = new Carro(
                "Renault", "Clio", "Azul", 2018, 90, 1500,
                TipoCombustivel.GASOLINA, 5.8, 5
        );

        Mota mota1 = new Mota(
                "Honda", "CB500", "Vermelho", 2022, 47, 500, 5.8,
                TipoCombustivel.GASOLINA
        );

        Mota mota2 = new Mota(
                "Yamaha", "MT07", "Preto", 2021, 75, 700, 4.8,
                TipoCombustivel.GPL
        );

        Camiao camiao1 = new Camiao(
                "Mercedes", "Actros", "Branco", 2019, 450, 12000, 8.9,
                TipoCombustivel.DIESEL, 18000
        );

        Camiao camiao2 = new Camiao(
                "Volvo", "FH16", "Cinza", 2020, 550, 16000, 8.9,
                TipoCombustivel.DIESEL, 25000
        );

    carro2.calcularConsumo(500);

        System.out.println("\n____________________________________________\n");

        mota1.imagem();

        System.out.println("\n____________________________________________\n");

        mota2.corrida(mota1).exibirDetalhes();

        System.out.println("\n____________________________________________\n");

        camiao2.viagem(150, 20);

        System.out.println("\n____________________________________________\n");

        camiao1.viagem(800, 20000);

    }
}
