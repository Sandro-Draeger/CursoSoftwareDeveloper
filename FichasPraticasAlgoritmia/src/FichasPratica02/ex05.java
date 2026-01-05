package FichasPraticas02;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2;

        System.out.println("insira um valor: ");
        num1 = input.nextInt();

        System.out.println("insira outro valor: ");
        num2 = input.nextInt();

        if (num1 > num2)
        {
            System.out.println(num1 + " " + num2);
        } else
            System.out.println(num2 + " " + num1);

        }
    }
