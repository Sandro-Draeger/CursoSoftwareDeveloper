package FichaPraticaExtra;

public class ex03 {
    static void main() {


        int resultado;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Tabuada do " + i);
            for (int y = 1; y <= 10; y++) {
                resultado = i * y;
                System.out.println(i + " x " + y + " = " + resultado);
            }
            }
    }
}
