package FichaPratica07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ex08 {

    public static void main(String[] args) throws FileNotFoundException {
        calcularNumeroVendas("ficheiros/exercicio_08.csv");
    }

    public static double calcularNumeroVendas(String caminho) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ficheiros/exercicio_08.csv"));

        double quantidade = 0;
        double preco = 0;
        double vendaTotal = 0;
        String linha = sc.nextLine();

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] partes = linha.split(",");

            quantidade = Double.parseDouble(partes[2]);
            preco = Double.parseDouble(partes[3]);
            vendaTotal += quantidade * preco;

        }

        System.out.println("Valor total das vendas: " + vendaTotal);
        return vendaTotal;
    }
}
