package FichasPraticas02.FichaPratica03;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = input.nextInt();

        int i = num - 5;

        while (i < num) {
            System.out.println(i);
            i++;
        }

        i = num + 1;
        while (i <= num + 5) {
            System.out.println(i);
            i++;
        }

    }
}