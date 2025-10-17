package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex09 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double media,num=0, soma=0;
        int contador=0;


        while (num != -1) {
            System.out.print("Insira número : ");
            num = input.nextDouble();

            contador++;

            soma = num+soma;

        }

        media = soma / (contador-1)
        System.out.println(media);
    }
}
