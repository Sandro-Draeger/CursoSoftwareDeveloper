package FichasPraticas02.FichaPratica06;

import java.util.Scanner;

public class BibliotecaLeitura {

    //-------------

    public static int lerInteiroPositivo() {

        Scanner input = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Insira um número inteiro e positivo: ");
            numero = input.nextInt();
        } while (numero < 0);

        return numero;
    }

//--------------------

    public static boolean par(int num) {

        if (num % 2 == 0) {
            return true;
        }

        return false;
    }


//---------------------

public static boolean positivo(int num) {

    if (num >= 0) {
        return true;
    }

    return false;
}


//------------------------

public static boolean primo(int num) {

    if (num >= 1) {
        if (num % 1 == 0 && num % num == 0) {
            return true;
        }
    }

    return false;
}

//-------------------------

public static boolean perfeito(int num) {

    int somaDivisores = 0;

    for (int i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            somaDivisores = somaDivisores + i;
        }
    }
    if (somaDivisores == num) {
        return true;
    }

    return false;
}

//------------------------

public static boolean triangular(int num) {

    for (int i = 1; i * (i + 1) * (i + 2) < num; i++) {
        if (i * (i + 1) * (i + 2) == num) {
            return true;
        }
    }

    return false;
}

//-------------------------
}