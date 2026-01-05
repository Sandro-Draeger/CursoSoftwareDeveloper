package FichasPraticas02;


import java.util.Scanner;


public class ex07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("insira um numero: ");
        int num = input.nextInt();
        if (num % 2 == 0) {
            System.out.println("par");
        } else {
            System.out.println("ímpar");
        }


    }
}
