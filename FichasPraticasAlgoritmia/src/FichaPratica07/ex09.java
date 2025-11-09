package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static FichaPratica07.ex07.contarLinhasFicheiro;

public class ex09 {

    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {


        int linhaAtual = 0;

        int contadorMusicas = contarLinhasFicheiro(caminho) - 1;

        String[][] matrizCompleta = new String[contadorMusicas][4];

        File ficheiroMusicas = new File(caminho);
        Scanner sc = new Scanner(ficheiroMusicas);

        String linha = sc.nextLine();

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaSeparada = linha.split(",");

            for (int coluna = 0; coluna < matrizCompleta[0].length; coluna++) {
                matrizCompleta[linhaAtual][coluna] = linhaSeparada[coluna];
            }

            linhaAtual++;
        }

        return matrizCompleta;
    }

}      public static String menuMusicas 