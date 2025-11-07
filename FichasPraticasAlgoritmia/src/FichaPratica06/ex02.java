package FichasPraticas02.FichaPratica06;

import java.util.Scanner;

public class ex02 {


    public static void imprimirAsteriscos(int numerosAsteriscos) {

        Scanner input = new Scanner(System.in);

        while (numerosAsteriscos >= 0) {
            System.out.println("insira números inteiros e positivos: ");
            numerosAsteriscos = input.nextInt();

            for (int i = 0; i < numerosAsteriscos; i++) {
                System.out.print("*");
            }
            System.out.println();

            if (numerosAsteriscos < 0) {
                System.out.println("número inválido");
                break;
            }

        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira números inteiros e positivos: ");
        int numerosAsteriscosInput = input.nextInt();

        imprimirAsteriscos(numerosAsteriscosInput);

    }
}


