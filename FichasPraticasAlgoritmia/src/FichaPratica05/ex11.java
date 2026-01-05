package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[3][3];
        int linha, coluna, menorNumero, maiorNumero;


        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print("Introduza o número para a posição [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        menorNumero = matriz[0][0];
        maiorNumero = matriz[0][0];

        System.out.println("------------------");

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }

        System.out.println("------------------");

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz.length; coluna++) {
                if (matriz[linha][coluna] < menorNumero) {
                    menorNumero = matriz[linha][coluna];
                }
                if (maiorNumero < matriz[linha][coluna]) {
                    maiorNumero = matriz[linha][coluna];
                }
            }

        }
        System.out.println("o Maior número da matriz é: " + maiorNumero + "\t" + "e o menor é: " + menorNumero);
    }

}
