package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][3];
        int linha, coluna;


        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print("Introduza o número para a posição [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }


        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }
    }
}
