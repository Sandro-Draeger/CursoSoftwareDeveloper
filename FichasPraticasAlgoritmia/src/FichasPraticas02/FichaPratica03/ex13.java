package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, multiplode5;

        System.out.println("Insira um valor de inicio: ");
        num1 = input.nextInt();

        System.out.println("Insira um valor de fim: ");
        num2 = input.nextInt();

        while (num1 < num2) {

            if (num1 % 5 ==0 ){
                num1 = num1+5;
                System.out.println(num1);
            }
        }
    }
}
