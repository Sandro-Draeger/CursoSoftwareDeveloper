package FichasPraticas02;

import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int salario;

        System.out.println("insira seu salário: ");
        salario = input.nextInt();

        if (salario <= 15000) {
            System.out.println("paga taxa de 20%: " + salario * 0.2);
        } else if (salario <= 20000) {
            System.out.println("paga taxa de 30%: " + salario * 0.3);
        } else if (salario <= 25000) {
            System.out.println("paga taxa de 35%: " + salario * 0.35);
        } else {
            System.out.println("paga taxa de 40%: " + salario * 0.40);

        }




    }
}


