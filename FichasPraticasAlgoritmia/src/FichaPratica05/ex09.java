package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[5][5];
        int linha, coluna, somaTotal = 0;


        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print("Introduza o número para a posição [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                somaTotal = somaTotal + matriz[linha][coluna];
            }
        }

        System.out.print(somaTotal);
    }
}