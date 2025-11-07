package FichasPraticas02.FichaPratica06;

import java.util.Scanner;


public class ex04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num, opcoes;

        System.out.println("Insira um número: ");
        num = input.nextInt();

        System.out.print("Escolha uma opção:\n");
        System.out.println("1 - Par\n" + "2 - Positivo\n" + "3 - Primo\n" + "4 - Perfeito\n" + "5 - Triângular\n");
        System.out.println("Opção: ");
        opcoes = input.nextInt();


        switch (opcoes) {
            case 1:
                if (BibliotecaLeitura.par(num)) {
                    System.out.println("O número é par.");
                } else {
                    System.out.println("O número é ímpar.");
                }
                break;

            case 2:
                if (BibliotecaLeitura.positivo(num)) {
                    System.out.println("O número é positivo.");
                } else {
                    System.out.println("O número é negativo.");
                }
                break;

            case 3:
                if (BibliotecaLeitura.primo(num)) {
                    System.out.println("O número é primo.");
                } else {
                    System.out.println("O número não é primo.");
                }
                break;

            case 4:
                if (BibliotecaLeitura.perfeito(num)) {
                    System.out.println("O número é perfeito.");
                } else {
                    System.out.println("O número não é perfeito.");
                }
                break;

            case 5:
                if (BibliotecaLeitura.triangular(num)) {
                    System.out.println("O número é triângular.");
                } else {
                    System.out.println("O número não é triângular");
                }
                break;

            default:
                System.out.println("Opção inválida!");
        }

    }
}
