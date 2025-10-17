package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex09_v2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double media, num = 0, soma = 1;
        int contador = -1;


        while (num != -1) {
            System.out.print("Insira número : ");
            num = input.nextDouble();

            soma = num + soma;
            contador++;

        }

        media = soma / contador;
        System.out.println(media);
    }
}
