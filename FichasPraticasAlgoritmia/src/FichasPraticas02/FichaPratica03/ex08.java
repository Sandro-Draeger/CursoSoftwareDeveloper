package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira um número: ");
        int num1 = input.nextInt();
        int i = 0;

        for (i = 0; i <= num1; i++ && i--){
           num1 = i*5;
        }
    }
}