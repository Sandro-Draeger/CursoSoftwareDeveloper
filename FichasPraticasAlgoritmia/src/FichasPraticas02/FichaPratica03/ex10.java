package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira um numero: ");
        int num = input.nextInt();

        while (num > 2) {

            num--;

            if (num % 2 == 0) {
                System.out.println(num);
            }
        }

    }
}
