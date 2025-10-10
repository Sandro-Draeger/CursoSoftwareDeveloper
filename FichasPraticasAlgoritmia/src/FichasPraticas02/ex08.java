package FichasPraticas02;


import java.util.Scanner;


public class ex08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("insira a primeira nota: ");
        double nota1 = input.nextDouble();
        System.out.println("insira a segunda nota: ");
        double nota2 = input.nextDouble();
        System.out.println("insira a terceira nota: ");
        double nota3 = input.nextDouble();
        double media = nota1 * + nota2 * 0.35 + nota3 * 0.4;
        if (media >= 9.5) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }


    }
}