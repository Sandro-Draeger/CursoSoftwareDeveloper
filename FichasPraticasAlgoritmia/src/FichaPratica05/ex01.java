package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[10];

        // preencher array
        for (int i = 0; i < array.length; i++) {
            System.out.print("Insira no array[" + i + "]: ");
            array[i] = input.nextInt();
        }

        System.out.println("____________________________");

        // imprimir array
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}