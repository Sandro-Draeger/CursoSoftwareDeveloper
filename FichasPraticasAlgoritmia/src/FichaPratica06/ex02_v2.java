package FichasPraticas02.FichaPratica06;

import java.util.Scanner;

import static FichasPraticas02.FichaPratica06.BibliotecaLeitura.lerInteiroPositivo;


public class ex02_v2 {

    public static void imprimirAsteriscos(int quantidade){
        for (int i = 0; i < quantidade; i++) {
            System.out.print("*");
        }
    }


    public static void main(String[] args) {

        imprimirAsteriscos(20);
        System.out.print(" PROGRAMA DOS ASTERISCOS ");
        imprimirAsteriscos(20);
        System.out.println();

        int num = lerInteiroPositivo();
        imprimirAsteriscos(num);

    }
}



