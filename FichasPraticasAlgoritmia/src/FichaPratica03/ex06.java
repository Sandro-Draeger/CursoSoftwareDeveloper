package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira o primeiro número: ");
        int num1 = input.nextInt();

        System.out.println("Insira o segundo número: ");
        int num2 = input.nextInt();

        for (int i = num1; i <= num2; i++){
            System.out.println(i);
        }
    }
}