package FichasPraticas01;

import java.util.Scanner;

public class ex03 {


public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int alt, comp, area, perimetro;

    System.out.print("Introduza a altura: ");
    alt = input.nextInt();

    System.out.print("Introduza o comprimento: ");
    comp = input.nextInt();

    area = alt * comp;
    System.out.println("A área do retângulo é " + area);

    perimetro = alt + alt + comp + comp;
    System.out.println("O perímetro do retângulo é " + perimetro);

}
}