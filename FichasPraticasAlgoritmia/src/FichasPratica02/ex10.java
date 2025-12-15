package FichasPraticas02;


import java.util.Scanner;


public class ex10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("insira um valor: ");
        double num1 = input.nextDouble();
        System.out.println("escolha uma operação aritmética");
        String operacao = input.next();
        System.out.println("insira outro valor: ");
        double num2 = input.nextDouble();
        switch (operacao) {
            case "+" -> System.out.println("soma: " + (num1 + num2));
            case "-" -> System.out.println("soma: " + (num1 - num2));
            case "*" -> System.out.println("soma: " + num1 * num2);
            case "/" -> System.out.println("soma: " + num1 / num2);
            default -> System.out.println("erro");
        }


    }
}
