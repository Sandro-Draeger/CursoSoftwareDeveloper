package ex01;

public class Main {
    public static void main() {
        Carro cominho = new Carro("chevrolet", "Astro", "Preto", 1980, 1000, 200, TipoCombustivel.DIESEL, 120);
        Carro oregano = new Carro("chevrolet", "Strada", "Branco", 1980, 1000, 200, TipoCombustivel.GPL, 130);
        Carro pimenta = new Carro("fiat", "Uno", "Branco", 2006, 800, 400, TipoCombustivel.GASOLINA, 140);
        Carro sal = new Carro("mercedes", "BW02", "Vermelho", 2020, 900, 600, TipoCombustivel.DIESEL, 100);

        cominho.ligarCarro();
        oregano.ligarCarro();
        pimenta.ligarCarro();
        sal.ligarCarro();

        System.out.println("\n\n________________________________\n");

        System.out.println("Corrida!");
        cominho.exibirDetalhes();
        System.out.println("VS");
        oregano.exibirDetalhes();

        System.out.println("\n\n________________________________\n");

        cominho.corrida(oregano);

        System.out.println("\n\n________________________________\n");

        System.out.println("Corrida!");
        pimenta.exibirDetalhes();
        System.out.println("VS");
        sal.exibirDetalhes();

        System.out.println("\n\n________________________________\n");

        pimenta.corrida(sal);

        System.out.println("\n\n________________________________\n");

        System.out.println("Corrida!");
        cominho.exibirDetalhes();
        System.out.println("VS");
        sal.exibirDetalhes();

        System.out.println("\n\n________________________________\n");

        cominho.corrida(sal);

        System.out.println("\n\n________________________________\n");

        System.out.println(cominho.calcularConsumo(65));
    }
}
