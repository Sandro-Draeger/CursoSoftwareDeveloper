package FichasPraticas01;

import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int valor1, valor2, valor3;

        System.out.println("digite o primeiro valor: ");
        valor1  = input.nextInt();

        System.out.println("digite o segundo valor: ");
        valor2 = input.nextInt();

        System.out.println(valor1+" | "+valor2);

        // __________________________________________________


       valor1 = valor1 + valor2;
       valor2 = valor1 - valor2;
       valor1 = valor1 - valor2;


        // __________________________________________________
        System.out.println("___ Valores trocados ___");
        System.out.println(valor1+" | "+valor2);
    }
}
