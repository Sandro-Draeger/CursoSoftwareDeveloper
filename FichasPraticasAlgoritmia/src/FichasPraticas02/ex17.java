package FichasPraticas02;

import java.util.Scanner;

public class ex17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Insira um valor em euros: ");
        double saldo = input.nextDouble();


        if (saldo<=2000) {
            System.out.println("Nenhum crédito");
        } else if (saldo<=4000) {
                System.out.println("20% aplicado: " + saldo*0.2); }
        else if (saldo<=6000) {
            System.out.println("30% aplicado: " + saldo*0.3);
        }
        else if (saldo>6000) {
            System.out.println("40% aplicado: " + saldo*0.4);
        } else {
            System.out.println("valor inválido");
        }


        }
    }



