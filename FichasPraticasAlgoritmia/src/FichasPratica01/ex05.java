package FichasPraticas01;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        double num1, num2, num3, media, mediaPonderada;

        System.out.print("Digite o primeiro número: ");
        num1 = input.nextDouble();

        System.out.print("Digite o segundo número: ");
        num2 = input.nextDouble();

        System.out.print("Digite o terceiro número: ");
        num3 = input.nextDouble();

        media = (num1 + num2 + num3) / 3;
        System.out.println("A média dos números é: " + media);

        mediaPonderada = (num1 * 0.2) + (num2 * 0.3) + (num3 * 0.5);
        System.out.println("A média ponderada dos números é: " + mediaPonderada);

    }
}
