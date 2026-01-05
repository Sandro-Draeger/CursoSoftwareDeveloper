package ex05;

public class Main {
    static void main() {
        Carro fiat = new Carro("fiat", "Uno", "preto", 1999);
        Carro mercedes = new Carro("Mercedes", "BW8", "branco", 2015);
        System.out.println(fiat.ligarCarro());
        System.out.println(mercedes.ligarCarro());
    }
}
