package FichasPraticas01;

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //variaveis
        double preco1, preco2, preco3, soma;

        // receber os valores
        System.out.println("insira o primeiro preço: ");
        preco1 = input.nextDouble();

        System.out.println("insira o segundo preço: ");
        preco2 = input.nextDouble();

        System.out.println("insira o terceiro preço: ");
        preco3 = input.nextDouble();

        //apresentar a soma aplicando 10% de desconto

        soma = preco1 + preco2 + preco3 * 0.10;
        System.out.println("preço com 10% de desconto: " + soma);

    }
}
