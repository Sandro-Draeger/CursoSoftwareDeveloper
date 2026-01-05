package Veiculos;

import Veiculos.Enums.TipoCombustivel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mota extends Veiculo{

    public Mota(String marca, String modelo, String cor, int anoFabrico, int potencia, int cilindrada, double consumoLitros, TipoCombustivel tipoCombustivel) {
        super(marca, modelo, cor, anoFabrico, potencia, cilindrada, consumoLitros, tipoCombustivel);
    }

    public void imagem() throws FileNotFoundException {
        File ficheiro = new File("src/ficheiro/Mota.txt");
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
        sc.close();
    }

}
