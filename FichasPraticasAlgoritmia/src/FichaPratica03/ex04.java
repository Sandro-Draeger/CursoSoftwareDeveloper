package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num;
        System.out.println("insira um número: ");
        num = input.nextInt();

        for(int i = 0; i <= num; i++) {
            System.out.println(i);
        }
    }
}