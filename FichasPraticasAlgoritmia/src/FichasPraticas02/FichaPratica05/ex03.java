package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[10];
        int i, maiorNum;

        for (i = 0; i < array.length; i++) {
            System.out.println("Insira o numero [" + i + "]: ");
            array[i] = input.nextInt();
        }

        maiorNum = array[0];


        for (i = 0; i < array.length; i++) {

            if (array[i] > maiorNum) {
                maiorNum = array[i];
            }

        }

        System.out.println(maiorNum);
    }
}
