package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numAtual, numAnterior, qtdLimite, contador = 1;
        boolean crescente = true;


        System.out.println("Quantos números deseja inserir: ");
        qtdLimite = input.nextInt();

        System.out.print("Insira o número: ");
        numAnterior = input.nextInt();

        while (contador < qtdLimite) {
            System.out.print("Insira o número: ");
            numAtual = input.nextInt();

            if (numAtual < numAnterior) {
//                System.out.println("Foi neste momento que deixou de ser crescente");
//                System.out.println("O número " + numAtual + " é menor que " + numAnterior);
                crescente = false;
            }

            numAnterior = numAtual;
            contador++;
        }

        if (crescente) { // crescente == true
            System.out.println("Crescente");
        } else {
            System.out.println("Não Crescente");
        }
    }
}


