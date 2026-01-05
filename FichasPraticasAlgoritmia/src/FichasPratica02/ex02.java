package FichasPraticas02;

import java.util.Scanner;

public class ex02 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

           double salarioLido, imposto;

           System.out.println("insira seu salário: ");
           salarioLido = input.nextDouble();

           if (salarioLido<=1500){
               imposto=salarioLido*0.2;
               System.out.println("taxa de 20%: " + imposto);}
           else {
               imposto=salarioLido*0.3;
               System.out.println("taxa de 30%: " + imposto);
           }
        }
}
