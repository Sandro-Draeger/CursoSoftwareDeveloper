package FichasPraticas02;


import java.util.Scanner;


public class ex09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("insira um valor: ");
        int num1 = input.nextInt();
        System.out.println("insira outro valor: ");
        int num2 = input.nextInt();
        System.out.println("insira mais um valor: ");
        int num3 = input.nextInt();


        if (num1 < num2 && num1 < num3) {
            System.out.println("menor numero: " + num1);
        } else if (num2 < num1 && num2 < num3) {
            System.out.println("menor numero: " + num2);
        } else {
            System.out.println("menor numero: " + num3);
        }


    }
}
