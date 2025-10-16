package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Insira uma frase: ");
        String frase = input.nextLine();

        System.out.println("Quantas vezes deseja repetir a frase: ");
        int repeticoes = input.nextInt();

        for (int i = 1; i <= repeticoes; i++) {
            System.out.println(frase);
        }
}
}
