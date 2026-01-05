package FichasPraticas02;

import java.util.Scanner;

public class ex12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Selecione uma opção: ");
        int menu = input.nextInt();

        switch (menu) {
        case 1 -> System.out.println("Criar");

        case 2 -> System.out.println("Atualizar");

        case 3 -> System.out.println("Eliminar");

        case 4 -> System.out.println();

        default -> System.out.println("Opção Inválida");
        }
    }

}
