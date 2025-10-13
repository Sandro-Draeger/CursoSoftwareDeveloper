package FichasPraticas02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ex16 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            System.out.print("Insira um valor em euros: ");
            int num = input.nextInt();

            // Notas disponíveis
            int[] euros = {200, 100, 50, 20, 10, 5};

            // Verifica se o valor é múltiplo de 5
            if (num % 5 != 0) {
                System.out.println("Valor inválido! Deve ser múltiplo de 5.");
                return; // Sai do programa
            }

            // Calcula o troco com o menor número de notas
            for (int nota : euros) {
                int qtdNotas = num / nota; // Quantas notas desse valor cabem
                if (qtdNotas > 0) {
                    System.out.println(nota + "€: " + qtdNotas + " nota(s)");
                    num %= nota; // Atualiza o valor restante
                }
            }
        }
    }