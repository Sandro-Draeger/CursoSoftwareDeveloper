package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[3];
        int i, menorNum;

        for (i = 0; i < array.length; i++) {
            System.out.println("Insira o numero [" + i + "]: ");
            array[i] = input.nextInt();
        }

        menorNum = array[0];


        for (i = 0; i < array.length; i++) {

            if (menorNum > array[i]) {
                menorNum = array[i];
            }

        }

        System.out.println(menorNum);
    }
}



