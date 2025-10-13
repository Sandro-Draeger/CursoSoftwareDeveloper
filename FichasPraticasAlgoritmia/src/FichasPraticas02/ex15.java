package FichasPraticas02;

import java.util.Scanner;

public class ex15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("insira um numero: ");
        int num1 = input.nextInt();

        System.out.println("insira um numero: ");
        int num2 = input.nextInt();

        System.out.println("insira um numero: ");
        int num3 = input.nextInt();

        System.out.println("insira C para crescente e D para decrescente: ");
        String escolha = input.next();


        switch (escolha) {
            case "C":
            case "c":
                if (num1 <= num2 && num1 <= num3) {
                    if (num2 <= num3) {
                        System.out.println(num1 + ", " + num2 + ", " + num3);
                    } else {
                        System.out.println(num1 + ", " + num3 + ", " + num2);
                    }
                } else if (num2 <= num1 && num2 <= num3) {
                    if (num1 <= num3) {
                        System.out.println(num2 + ", " + num1 + ", " + num3);
                    } else {
                        System.out.println(num2 + ", " + num3 + ", " + num1);
                    }
                } else {
                    if (num1 <= num2) {
                        System.out.println(num3 + ", " + num1 + ", " + num2);
                    } else {
                        System.out.println(num3 + ", " + num2 + ", " + num1);
                    }
                } break;
            case "D":
            case "d":
                if (num1 >= num2 && num1 >= num3) {
                    if (num2 >= num3) {
                        System.out.println(num1 + ", " + num2 + ", " + num3);
                    } else {
                        System.out.println(num1 + ", " + num3 + ", " + num2);
                    }
                } else if (num2 >= num1 && num2 >= num3) {
                    if (num1 >= num3) {
                        System.out.println(num2 + ", " + num1 + ", " + num3);
                    } else {
                        System.out.println(num2 + ", " + num3 + ", " + num1);
                    }
                } else {
                    if (num1 >= num2) {
                        System.out.println(num3 + ", " + num1 + ", " + num2);
                    } else {
                        System.out.println(num3 + ", " + num2 + ", " + num1);
                    }
                } break;
            default:
                System.out.println("Inválido");
        }
    }
}
