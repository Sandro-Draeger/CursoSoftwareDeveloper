package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        int linha, coluna, somaTotal = 0;


        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print("Introduza o número para a posição [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                if(linha == coluna){
                    somaTotal = matriz[linha][coluna] + somaTotal;
                }
            }
        }

        System.out.print(somaTotal);
    }
}