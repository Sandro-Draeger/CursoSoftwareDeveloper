package FichasPraticas01;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double area, raio;

        System.out.print("introduza o raio do círculo: ");

        raio = input.nextDouble();

        area = 3.14 * raio * raio;

        System.out.println("a área é " + area);

    }
}
