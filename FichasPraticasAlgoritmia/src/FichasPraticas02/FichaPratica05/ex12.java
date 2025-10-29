package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[][] matriz = new int[10][2];


        for (int i = 0; i < array1.length; i++) {
            System.out.print("Insira na primeira array[" + i + "]: ");
            array1[i] = input.nextInt();
            matriz[i][0] = array1[i];

        }

        for (int i = 0; i < array2.length; i++) {
            System.out.print("Insira na segunda array[" + i + "]: ");
            array2[i] = input.nextInt();
            matriz[i][1] = array2[i];

        }


        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}
