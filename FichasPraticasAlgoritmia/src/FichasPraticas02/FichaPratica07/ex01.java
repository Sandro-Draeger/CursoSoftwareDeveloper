import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex01 {

    public static void imprimirFicheiro(String caminho) throws FileNotFoundException {
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }

        sc.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Chama a função passando o nome do ficheiro
        imprimirFicheiro("dados.txt");
    }
}
