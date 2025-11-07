package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[10];
        int i = 0, numAnterior;
        boolean crescente = true;


        for (i = 0; i < array.length; i++) {
            System.out.print("Insira o número: ");
            array[i] = input.nextInt();
        }

        numAnterior = array[0];

        for (i = 0; i < array.length; i++)
            if (array[i] < numAnterior) {
                crescente = false;
            }

        if (crescente) { // crescente == true
            System.out.println("Crescente");
        } else {
            System.out.println("Não Crescente");
        }

    }
}