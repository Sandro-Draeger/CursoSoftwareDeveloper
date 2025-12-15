package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex07 {

    // Conta o número de linhas do ficheiro
    public static int contarLinhasFicheiro(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contadorLinhas = 0;

        while (sc.hasNextLine()) {
            contadorLinhas++;
            sc.nextLine();
        }

        sc.close();
        return contadorLinhas;
    }

    // Conta o número de palavras do ficheiro
    public static int contadorPalavrasFicheiro(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contadorPalavras = 0;

        while (sc.hasNext()) {
            sc.next(); // lê uma palavra
            contadorPalavras++;
        }

        sc.close();
        return contadorPalavras;
    }
}
