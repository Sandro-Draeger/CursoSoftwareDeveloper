package FichasPraticas02.FichaPratica03;

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int limite, salto;

        System.out.println("Insira um valor de limite: ");
        limite = input.nextInt();

        System.out.println("defina um valor para o salto: ");
        salto = input.nextInt();

        while (limite > 0) {

            limite = limite - salto;

            System.out.println(limite);
        }
    }
}
