package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 1, contador = 0, contador2 = 0, contador3 = 0, contador4 = 0;

        while (num > 0) {
            System.out.print("Insira número: ");
            num = input.nextInt();

            if (num <= 25 && num > 0) {
                contador++;

            }
            if (num >= 26 && num <= 50) {
                contador2++;

            }
            if (num >= 51 && num <=75) {
                contador3++;

            }
            if (num >= 76 && num <= 100) {
                contador4++;
            }

        }
        System.out.println("[26,50]: " + contador);
        System.out.println("[26,50]: " + contador2);
        System.out.println("[51,75]: " + contador3);
        System.out.println("[76,100]: " + contador4);
        }
}