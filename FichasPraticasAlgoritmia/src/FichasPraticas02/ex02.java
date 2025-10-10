package FichasPraticas02;

import java.util.Scanner;

public class ex02 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

           int salarioLido;

           System.out.println("insira seu salário: ");
           salarioLido = input.nextInt();

           if (salarioLido<=1500){
               System.out.println(salarioLido*0.2);}
           else {
               System.out.println(salarioLido*0.3);
           }
        }
}
