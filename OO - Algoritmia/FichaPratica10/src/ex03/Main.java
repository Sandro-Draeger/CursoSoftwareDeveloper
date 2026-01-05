package ex03;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;

public class Main {
    static void main() {
        Peixe lambari = new Peixe("Lambari",50, 30);
        Peixe bacalhau = new Peixe("Bacalhau",10, 30);
        Peixe sardinha = new Peixe("Sardinha",20, 50);

        Marisco camarao = new Marisco("Camarão", 0.1, 1);
        Marisco ostra = new Marisco("Ostra", 0.5, 3);
        Marisco carangueijo = new Marisco("Carangueijo", 1.5, 9);

        BarcoPesca gp5 = new BarcoPesca("GP05", "Branco", "2010", 10, 100, Marca.Bentz);

        gp5.pescarPeixe(lambari);
        gp5.pescarPeixe(sardinha);
        gp5.pescarMarisco(camarao);
        gp5.pescarPeixe(bacalhau);
        gp5.pescarMarisco(ostra);
        gp5.pescarMarisco(carangueijo);
        gp5.pescarPeixe(sardinha);

        gp5.exebirDetalhes();

        gp5.calcularTotal();

        gp5.salarioTripulacao();
    }
}
