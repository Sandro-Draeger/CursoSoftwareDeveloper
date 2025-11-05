package FichasPraticas02.FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) throws FileNotFoundException {
        lerFicheiro();
    }

    public static void lerFicheiro() throws FileNotFoundException {
        Scanner ficheiro = new Scanner(new File("FichaPratica07/ficheiros/exercicio_06.txt"));


        int idade = 0;
        int maiorIdade = 0;
        String linha = "";
        String nome = "";


        while (ficheiro.hasNextLine()) {
            String[] partes = linha.split(",");
            nome = partes[0];
            idade = Integer.parseInt(partes[0]);
        }
        System.out.println(idade);

    }

}