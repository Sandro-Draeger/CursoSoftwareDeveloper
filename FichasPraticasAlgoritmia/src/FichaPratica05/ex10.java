package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] matriz = new int[2][3];
        int linha, coluna, qtd = 0;


        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print("Introduza o número para a posição [" + linha + "][" + coluna + "]: ");
                matriz[linha][coluna] = input.nextInt();
            }
        }

        System.out.println("---------------");

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.println();
        }

        System.out.println("Insira um número para pesquisar: ");
        int numPesquisa = input.nextInt();

        for (linha = 0; linha < matriz.length; linha++) {
            for (coluna = 0; coluna < matriz[0].length; coluna++) {
                if (numPesquisa == matriz[linha][coluna]) {
                    qtd = qtd + 1;
                }
            }
        }
        System.out.println("há " + qtd + " posições na matriz com o número: " + numPesquisa);
    }

}
