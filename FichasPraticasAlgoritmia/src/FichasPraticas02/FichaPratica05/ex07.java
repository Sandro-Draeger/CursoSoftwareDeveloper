package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array = new int[4];
        int i = 0, maiorNum;

        for (i = 0; i < array.length; i++) {
            System.out.print("Insira o número: ");
            array[i] = input.nextInt();
        }

        maiorNum = array[0];

        for (i = 0; i < array.length; i++) {

            if (array[i] > maiorNum) {
                maiorNum = array[i];
                if (array[i] % 2 == 0) {
                    System.out.println("O maior número par é: " + maiorNum);
                } else {
                    System.out.println("Não existe número par");
                }
            }
        }
    }

}
