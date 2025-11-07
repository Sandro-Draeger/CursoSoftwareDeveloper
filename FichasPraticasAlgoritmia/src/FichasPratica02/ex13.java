package FichasPraticas02;

import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.println("Horas no sistema 24h: ");
        int hora = input.nextInt();

        System.out.println("Minutos: ");
        int minuto = input.nextInt();


        if (hora <= 12) {
            System.out.println("A hora é: " + (hora) + ":" + minuto + "am"); }
        else if (hora > 12) {
            System.out.println("A hora é: " + (hora-12) + ":" + minuto + "pm");
        }
        }



}
