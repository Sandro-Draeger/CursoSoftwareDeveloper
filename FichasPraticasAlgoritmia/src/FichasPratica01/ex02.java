package FichasPraticas01;

import java.util.Scanner;

public class ex02 {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int num1, num2, soma, subtracao, multiplicacao, divisao;

    System.out.print("Introduza um numero: ");
    num1 = input.nextInt();

    System.out.print("Introduza outro numero: ");
    num2 = input.nextInt();


    soma = num1 + num2;
    System.out.println("soma: " + soma);

    subtracao = num1 - num2;
    System.out.println("subtração: " + subtracao);

    multiplicacao = num1 * num2;
    System.out.println("multiplicação: " + multiplicacao);

    divisao = num1 / num2;
    System.out.println("divisão: " + divisao);

}
}