package FichasPraticas02;

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("insira um numero: ");
        int num1 = input.nextInt();

        System.out.println("insira um numero: ");
        int num2 = input.nextInt();

        System.out.println("insira um numero: ");
        int num3 = input.nextInt();

        //PRECISO REVER ISSO AQUI
        if (num1 > num3 && num2 < num3) {
            System.out.println(num1, num2, num3);
        } else {
            System.out.println("erro");
        }
    }
}
