package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[10];
        int i, media = 0, soma = 0;

        for (i = 0; i < array.length; i++) {
            System.out.println("Insira o numero [" + i + "]: ");
            array[i] = input.nextInt();

            soma = array[i] + soma;

            media = soma / 10;
        }

        System.out.println("A média das elementos é: " + media);
    }
}