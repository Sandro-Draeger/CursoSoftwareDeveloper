package FichasPraticas02.FichaPratica05;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] comissao = new double[12];
        double totalComissao = 0;
        int i = 0;

        for (i = 0; i < comissao.length; i++) {

            System.out.println("comissão do mês[" + i + "]: ");
            comissao[i] = input.nextDouble();
        }

        System.out.println("------");

        for (i = 0; i < comissao.length; i++) {
            totalComissao = comissao[i] + totalComissao;
        }
        System.out.println("total do ano: " + totalComissao);
    }
}